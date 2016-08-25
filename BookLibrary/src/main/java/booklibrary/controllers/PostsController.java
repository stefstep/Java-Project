package booklibrary.controllers;

import booklibrary.forms.CreatePostForm;
import booklibrary.forms.RegisterForm;
import booklibrary.models.Post;
import booklibrary.models.User;
import booklibrary.pagination.Pager;
import booklibrary.services.NotificationService;
import booklibrary.services.PostService;
import booklibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class PostsController {

    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = { 5, 10, 20 };

    @Autowired
    private UserService userService;


    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }

    @RequestMapping("/posts/index")
    public ModelAndView showPostPage(@RequestParam(value= "pageSize", required = false) Integer pageSize, @RequestParam(value = "page", required = false) Integer page){
        ModelAndView modelAndView = new ModelAndView("posts/index");

        int evalPageSize = pageSize == null ? INITIAL_PAGE_SIZE : pageSize;

        int evalPage = (page == null || page < 1) ? INITIAL_PAGE : page - 1;

        Page<Post> posts = postService.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(posts.getTotalPages(), posts.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("posts", posts);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);

        return modelAndView;
    }

    @RequestMapping("/posts/create")
    public String createPost(CreatePostForm createPostForm) {
        return "posts/create";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String registerPage(@ModelAttribute("postForm") Post post, @Valid CreatePostForm createPostForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "posts/create";
        }
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        post.setTitle(createPostForm.getTitle());
        post.setBody(createPostForm.getBody());
        post.setDate(new Date());
        post.setAuthor(user);
        //post.setAuthor(user);

        postService.create(post);

        notifyService.addInfoMessage("Post create successful");
        return "redirect:/posts/index";
    }

    @RequestMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable("id") Long id){
        postService.deleteById(id);
        notifyService.addInfoMessage("Post delete successful");
        return "redirect:/posts/index";
    }

    @RequestMapping("/posts/confirmdelete/{id}")
    public String deletePost(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);

        model.addAttribute("post", post);

        return "posts/delete";
    }

    @RequestMapping("/posts/details/{id}")
    public String detailsPost(@PathVariable("id") Long id, Model model){

        Post post = postService.findById(id);

        model.addAttribute("post", post);

        return "posts/details";
    }

    @RequestMapping("/posts/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, CreatePostForm createPostForm){

        Post post = postService.findById(id);

        model.addAttribute("post", post);

        return "posts/edit";
    }

    @RequestMapping("**/changePost")
    public String saveProduct(@ModelAttribute("postForm") Post post, @Valid CreatePostForm createPostForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/register";
        }

        User user = userService.findById((long)3);

        post.setTitle(createPostForm.getTitle());
        post.setBody(createPostForm.getBody());
        post.setDate(new Date());
        //post.setAuthor((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        post.setAuthor(user);

        postService.edit(post);
        notifyService.addInfoMessage("Post change successful");
        return "redirect:/posts/index";
    }
}

