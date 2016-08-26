package blog.controllers;

import blog.models.Post;
//import blog.services.NotificationService;
//import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeContoller {
    // @Autowired
    // private PostService postService;

    //@Autowired
    // private NotificationService notifyService;

    @RequestMapping("/")
    public  String Index(Model model){
        /*List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);
        List<Post> latest3Posts = latest5Posts.stream()
                .limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);
        */
        return "index2";
    }
    @RequestMapping("new")
    public String OnePost(Model model, Long id){
       /* Post findPostById = postService.findById(id);
        if(findPostById == null){
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("findPostById", findPostById);
        */
        return "new";
    }
}
