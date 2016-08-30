package blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeContoller {
   // @Autowired
   // private PostService postService;

    //@Autowired
   // private NotificationService notifyService;
    @RequestMapping("/")
    public  String Index(Model model){
       // String sidebarHome="sidebar/sidebarhome";
       // model.addAttribute("sidebar", sidebarHome);
        model.addAttribute("msg",
               "sidebar/sidebarhome");
        return "index";
    }
    @RequestMapping("/posts")
    public  String Post(Model model){
        //String sidebarstr="sidebar/sidebarPost";
       //  model.addAttribute("msg", sidebarstr);
        model.addAttribute("msg",
                "sidebar/sidebarpost");
        return "index";//"index";
    }
    @RequestMapping("/books")
    public  String Books(Model model){
        //String sidebarstr="sidebar/sidebarbook";
       // model.addAttribute("msg", sidebarstr);
        model.addAttribute("msg",
            "sidebar/sidebarbook");
        return "index";
    }
    @RequestMapping("/events")
    public  String Events(Model model){
       // String sidebarstr="sidebar/sidebarEvents";
       // model.addAttribute("msg", sidebarstr);
        model.addAttribute("msg",
            "sidebar/sidebarevents");
        return "index";
    }

    @RequestMapping("/users")
    public  String Users(Model model){
       // String sidebarstr="sidebar/sidebarUser";
       // model.addAttribute("msg", sidebarstr);
        model.addAttribute("msg",
                "users/userbegin");
        //"sidebar/sidebaruser");
        return "users";
    }
    @RequestMapping("/SpringAddUrl")
    public  String Index2(Model model){
        return "SpringAddUrl";
    }

    @RequestMapping("jquarytry")
    public String JQuaryTry(Model model, Long id){
        model.addAttribute("msg",
                // "message text");
                "sidebar/sidebarhome");
        model.addAttribute("msgtwo",
                // "message text");
                "sidebar-home");
        return "jquarytry2";
    }
}
