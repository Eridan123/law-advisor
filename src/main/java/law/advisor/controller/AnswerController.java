package law.advisor.controller;

import law.advisor.model.Answer;
import law.advisor.model.Content;
import law.advisor.model.Question;
import law.advisor.model.User;
import law.advisor.repository.AnswerRepository;
import law.advisor.repository.ContentRepository;
import law.advisor.repository.QuestionRepository;
import law.advisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class AnswerController {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContentRepository contentRepository;

    @RequestMapping("/question/{questionId}/answer/{answerId}/save")
    public String addAnswer(ModelMap model, @PathVariable("questionId") Long questionId,
                            @PathVariable("answerId") Long answerId){

        if(answerId==0 || answerId==null){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user=userRepository.findUserByUsername(auth.getName());
            Question question=questionRepository.getOne(questionId);
            Answer answer=new Answer();
            answer.setQuestion(question);
            answer.setDate(new Date());
            answer.setUser(user);
            model.addAttribute("answer",answer);
        }
        else if(answerId>0){
            Answer answer=answerRepository.getOne(answerId);
            model.addAttribute("answer",answer);
        }

        return "/answer/form";

    }

    @PostMapping("/answer/save")
    public String saveAnswer(Answer answer,Content content){


        if(answer.getId()==null||answer.getId()==0){
            contentRepository.save(content);
            answer.setContent(content);
            answerRepository.save(answer);
        }
        else if(answer.getId()>0){
            Content content1=contentRepository.getOne(content.getId());
            content1.setText(content.getText());
            contentRepository.save(content1);
            answerRepository.save(answer);
        }

        return "redirect: /question/"+answer.getQuestion().getId()+"/view";
    }

    @PostMapping("/answer/{id}/delete")
    public String delete(@PathVariable("id") Long id){

        Answer answer=answerRepository.getOne(id);
        Long questionId=answer.getQuestion().getId();
        answerRepository.delete(answer);
        return "redirect: /question/"+questionId+"/view";
    }

}
