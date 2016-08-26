package blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by RoYaL on 8/23
 * */
@RestController
public class MyController {

    @RequestMapping(value = "/here")
    String index() {
        return "zdrasti :)";
    }
}
