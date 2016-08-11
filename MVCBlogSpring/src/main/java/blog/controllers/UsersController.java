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
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    NotificationService notifyService;

    @RequestMapping("/allUsers")
    public  String Posts(Model model){
        List<User> allUsers = userService.findAll();
        model.addAttribute("allUsers", allUsers);
        return "allUsers";
    }
}
