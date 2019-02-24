package law.advisor.controller;

import law.advisor.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/signup")
    public String signup(ModelMap model){
        model.addAttribute("user",new User());

        return "/signup";
    }

    @RequestMapping("/login")
    public String login(ModelMap model){

        return "/login";
    }



    @RequestMapping({"/user","/user/list"})
    public String list(ModelMap model){


        model.addAttribute("hello","Hello");
        return "/hello";
    }
}
