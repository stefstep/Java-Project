package blog.controllers.UserControllers;

import blog.forms.UserForms.RegisterForm;
import blog.models.ExcptnUserForm;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    private static final Logger logger =
            Logger.getLogger(RegisterController.class.getName());



    @Autowired
    UserService userService;

    @Autowired
    NotificationService notifyService;

    @RequestMapping("/users/register")
    public String register(Model model,RegisterForm registerForm) {
        ExcptnUserForm checkmsg =new ExcptnUserForm();
        checkmsg.setUserchekmsg("");
        checkmsg.setNamecheckmsg("");
        checkmsg.setMeilcheckmsg("this email address exists!");
      //checkmsg);
        return "register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerPage(Model model,
                               @ModelAttribute("userForm") User user, @Valid RegisterForm registerForm, BindingResult bindingResult
              ) {
        ExcptnUserForm checkmsg =new ExcptnUserForm();
        checkmsg.setUserchekmsg("");
        checkmsg.setNamecheckmsg("");
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "register";
        }
        boolean check=userService.checkUsername (registerForm.getUsername());
       if (check) {
                checkmsg.setUserchekmsg("Exist user");
           //notifyService.addErrorMessage("Change the username value!");
           //notifyService.addInfoMessage("Change username");
          // model.addAttribute("usr", "Change username.");
         //  return "register";
       }
        check=userService.checkEmailExist(registerForm.getEmail());
        if (check) {
            checkmsg.setMeilcheckmsg("this email address exists!");
        }

        checkmsg.setMeilcheckmsg("this email address exists!");

        model.addAttribute("Checkuser",checkmsg.getUserchekmsg());
        model.addAttribute("Checkmeil",checkmsg.getMeilcheckmsg());
                //"Value:"+registerForm.getEmail());
        if (!userService.authenticate(
                registerForm.getUsername(), registerForm.getPassword_hash(), registerForm.getFullname()
               ,registerForm.getEmail())) {
            notifyService.addErrorMessage("Invalid login! check="+check);
            return "register";
        }

        userService.create(user);

        notifyService.addInfoMessage("Register successful");
        return "redirect:/";
    }
}
