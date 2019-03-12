package law.advisor.controller;

import law.advisor.model.Question;
import law.advisor.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;


    @RequestMapping(value = {"/question","/question/list"})
    public String list(ModelMap model){

        List<Question> questions=questionRepository.findAll();

        model.addAttribute("questions",questions);

        return "/question/list";

    }

    @RequestMapping(value = {"/question/{category_id}/list"})
    public String getByCategory(@PathVariable("category_id") Long category_id,ModelMap model){

        List<Question> questions=questionRepository.findByCategory_Id(category_id);

        model.addAttribute("questions",questions);

        return "/question/list";
    }
}
