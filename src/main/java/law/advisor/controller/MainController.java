package law.advisor.controller;

import law.advisor.model.Category;
import law.advisor.model.Question;
import law.advisor.model.User;
import law.advisor.repository.CategoryRepository;
import law.advisor.repository.QuestionRepository;
import law.advisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String  index(ModelMap model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user=null;
        try{

            user= userRepository.findUserByUsername(auth.getName());
        }
        catch (Exception e){
            System.out.println(e);
        }
        if(user!=null){
            model.addAttribute("user",user);
        }
        else{
            model.addAttribute("user",null);
        }

        List<Question> questions=questionRepository.findAll();
        List<Category> categories=categoryRepository.findAll();

        model.addAttribute("questions",questions);
        model.addAttribute("categories",categories);
        return "/home";
    }

//    return news page
    @RequestMapping("/news")
    public String getNewsPage(ModelMap model){

        model.addAttribute("categories",categoryRepository.findAll());

        return "/news";
    }

    //    return about us page
    @RequestMapping("/aboutus")
    public String getAboutUsPage(ModelMap model){

        model.addAttribute("categories",categoryRepository.findAll());

        return "/aboutus";
}
}
