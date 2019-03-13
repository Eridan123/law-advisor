package law.advisor.controller;

import law.advisor.model.Content;
import law.advisor.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class MainController {

    @RequestMapping("/")
    public String  index(ModelMap model){
        Long l = Long.valueOf(1);
        Question question = new Question();
        question.setId(l);
        question.setTitle("First title");
        Content content = new Content();
        content.setId(Long.valueOf(1));
        content.setText("Hello world  how are you");
        model.addAttribute("questions",question);
        model.addAttribute("content", content);
        return "home";
    }
}
