package blog.controllers;

import blog.foms.CreatePostForm;
import blog.foms.RegisterForm;
import blog.models.Post;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.PostService;
import blog.services.UserService;
import blog.springframework.security.samples.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hristo on 10.08.2016 г..
 */

@Controller
public class PostsController {

    @Autowired
    PostService postService;

    @Autowired
    NotificationService notifyService;

    @RequestMapping("/allPosts")
    public  String Posts(Model model){
        List<Post> allPosts = postService.findAll();
        model.addAttribute("allPosts", allPosts);
        return "allPosts";
    }

    @RequestMapping("/posts/create")
    public String createPost(CreatePostForm createPostForm) {
        return "create";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPage(@ModelAttribute("postForm") Post post, @Valid CreatePostForm createPostForm, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "create";
        }

        postService.create(post);

        notifyService.addInfoMessage("Post create successful");
        return "redirect:/allPosts";
    }
}
