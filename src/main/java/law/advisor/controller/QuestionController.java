package law.advisor.controller;

import law.advisor.model.*;
import law.advisor.repository.CategoryRepository;
import law.advisor.repository.ContentRepository;
import law.advisor.repository.QuestionRepository;
import law.advisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class QuestionController {

    @Autowired
    EntityManager entityManager;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

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
        model.addAttribute("categoryId",category_id);

        return "/question/list";
    }

    @RequestMapping("/question/{id}/view")
    public String viewQuestion(ModelMap model,@PathVariable("id") Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user=userRepository.findUserByUsername(auth.getName());
        String role = user.getUserType().toString();

        Question question=questionRepository.getOne(id);

        model.addAttribute("role", role);
        model.addAttribute("question",question);
        return "/question/view";
    }


    @RequestMapping("/question/{id}/save")
    public String addQuestion(ModelMap model,@PathVariable("id") long id){

        if(id==0){

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user=userRepository.findUserByUsername(auth.getName());

            Question question=new Question();
            Content content=new Content();
            contentRepository.save(content);
            question.setContent(content);
            question.setDate(new Date());
            question.setUser(user);
            model.addAttribute("question",question);
        }
        else{
            model.addAttribute("question",questionRepository.getOne(id));
        }
        model.addAttribute("categories",categoryRepository.findAll());
        return "/question/form";
    }

    @PostMapping("/question/save")
    public String saveQuestion(Question question, String text){

        if(question.getId()==null){
            Content content1=question.getContent();
            content1.setText(text);
            contentRepository.save(content1);
            questionRepository.save(question);
        }
        else if(question.getId()>0){
            Content content1=question.getContent();
            content1.setText(text);
            contentRepository.save(content1);
            questionRepository.save(question);
        }
        return "redirect:/question/"+question.getId()+"/view";
    }

    @PostMapping("/question/{id}/delete")
    public String delete(@PathVariable("id") Long id){

        Question question=questionRepository.getOne(id);
        questionRepository.delete(question);

        return "redirect: /";
    }

    @GetMapping("/question/{searchStr}/search")
    public String search(@PathVariable(value = "searchStr",required = false) String searchStr,ModelMap model){

        if(searchStr.equals(" ")){
            searchStr="";
        }
        String baseQuery="select *\n" +
                "from question where title  like '%"+searchStr+"%'";
        Query query=entityManager.createNativeQuery(baseQuery,Question.class);
        List<Question> questions=query.getResultList();

        model.addAttribute("questions",questions);
        model.addAttribute("categories",categoryRepository.findAll());

        return "/question/questions";
    }

    @GetMapping("/question/category/{catId}/{searchStr}/search")
    public String searchByCategory(@PathVariable(value = "searchStr",required = false) String searchStr,@PathVariable(value = "catId",required = false) String catId,ModelMap model){

        if(searchStr.equals(" ")){
            searchStr="";
        }
        String baseQuery="select *\n" +
                "from question where category_id="+catId+" and  title  like '%"+searchStr+"%'";
        Query query=entityManager.createNativeQuery(baseQuery,Question.class);
        List<Question> questions=query.getResultList();

        model.addAttribute("questions",questions);
        model.addAttribute("categories",categoryRepository.findAll());

        return "/question/questions";
    }
}
