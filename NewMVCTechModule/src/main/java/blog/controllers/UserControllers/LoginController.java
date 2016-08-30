package blog.controllers.UserControllers;

import blog.forms.UserForms.LoginForm;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.text.MutableAttributeSet;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/users/login")
    public String login(LoginForm loginForm,Model model) {
           model.addAttribute("msg",
                "users/login");
        return "users";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult
             ,Model model) {
                model.addAttribute("msg", "users/login");
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users";
        }
/*
        if (userService.chk(
                loginForm.getUsername(), loginForm.getPassword()) == false) {
            notifyService.addErrorMessage("Invalid login!");
            return "users";
        }
*/
        notifyService.addInfoMessage("Login successful");
        return "redirect:/";
    }
}
