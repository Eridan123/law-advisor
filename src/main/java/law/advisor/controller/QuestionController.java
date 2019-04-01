package law.advisor.controller;

import law.advisor.model.Answer;
import law.advisor.model.Question;
import law.advisor.model.Role;
import law.advisor.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    /* This function returns the page with list of questions */
    @RequestMapping(value = {"/question","/question/list"})
    public String list(ModelMap model){

        List<Question> questions=questionRepository.findAll();

        model.addAttribute("questions",questions);

        return "/question/list";

    }
    
    /* This function returns the page with the list of questions of a particular category   */
    @RequestMapping(value = {"/question/{category_id}/list"})
    public String getByCategory(@PathVariable("category_id") Long category_id,ModelMap model){

        List<Question> questions=questionRepository.findByCategory_Id(category_id);

        model.addAttribute("questions",questions);

        return "/question/list";
    }

    @RequestMapping("/question/{id}/view")
    public String viewQuestion(ModelMap model,@PathVariable("id") long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Role role = (Role) auth.getAuthorities();
        model.addAttribute("role", role);

        return "/question/form";
    }

    @RequestMapping("/question/{id}/save")
    public String addQuestion(ModelMap model,@PathVariable("id") long id){

        if(id==0){
            model.addAttribute("question",new Question());
        }
        else{
            model.addAttribute("question",questionRepository.getOne(id));
        }
        return "/question/form";
    }

    @PostMapping("/question/save")
    public String saveQuestion(Question question){

        if(question.getId()==null){
            questionRepository.save(question);
        }
        else if(question.getId()>0){
            questionRepository.save(question);
        }
        return "redirect: /question/"+question.getId()+"/view";
    }

    @PostMapping("/question/{id}/delete")
    public String delete(@PathVariable("id") Long id){

        Question question=questionRepository.getOne(id);
        questionRepository.delete(question);

        return "redirect: /";
    }
}
