package blog.controllers;

import blog.foms.RegisterForm;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Hristo on 05.08.2016 г..
 */

@Controller
public class RegisterController {

    @Autowired UserService userService;

    @Autowired NotificationService notifyService;

    @RequestMapping("/users/register")
    public String register(RegisterForm registerForm) {
        return "register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerPage(@ModelAttribute("userForm") User user, @Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "register";
        }

        if (!userService.authenticate(
                registerForm.getUsername(), registerForm.getPassword(), registerForm.getFullname())) {
            notifyService.addErrorMessage("Invalid login!");
            return "register";
        }

        userService.create(user);

        notifyService.addInfoMessage("Register successful");
        return "redirect:/";
    }
}
