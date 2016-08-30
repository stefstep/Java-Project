package blog.controllers.UserControllers;


import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Hristo on 10.08.2016 г..
 */

@Controller
public class FindUsersController {

    @Autowired
    UserService userService;

    @Autowired
    NotificationService notifyService;

    @RequestMapping("/users/find")
    public  String FindAllUsers(Model model){
        model.addAttribute("msg",
                "users/finduser");
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
