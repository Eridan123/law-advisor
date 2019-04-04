package law.advisor.controller;

import law.advisor.model.*;
import law.advisor.repository.ContentRepository;
import law.advisor.repository.QuestionRepository;
import law.advisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    UserRepository userRepository;

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

    @RequestMapping("/question/view")
    public String viewQuestion(ModelMap model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = principal.toString();

        User user = userRepository.findUserByUsername(username);

        UserType userType = user.getUserType();
        String role = userType.toString();

        model.addAttribute("role", role);
        return "/question/view";
    }


    @RequestMapping("/question/{id}/save")
    public String addQuestion(ModelMap model,@PathVariable("id") long id){

        if(id==0){

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user=userRepository.findUserByUsername(auth.getName());

            Question question=new Question();
            question.setDate(new Date());
            question.setUser(user);
            model.addAttribute("question",question);
        }
        else{
            model.addAttribute("question",questionRepository.getOne(id));
        }
        return "/question/form";
    }

    @PostMapping("/question/save")
    public String saveQuestion(Question question, Content content){

        if(question.getId()==null){
            contentRepository.save(content);
            question.setContent(content);
            questionRepository.save(question);
        }
        else if(question.getId()>0){
            Content content1=contentRepository.getOne(content.getId());
            content1.setText(content.getText());
            contentRepository.save(content1);
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
