package booklibrary.controllers;

import booklibrary.models.User;
import booklibrary.services.NotificationService;
import booklibrary.services.UserService;
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
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    NotificationService notifyService;

    @RequestMapping("/users")
    public  String Posts(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
