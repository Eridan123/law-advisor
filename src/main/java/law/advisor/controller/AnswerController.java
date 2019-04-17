package law.advisor.controller;

import law.advisor.model.Answer;
import law.advisor.model.Content;
import law.advisor.model.Question;
import law.advisor.model.User;
import law.advisor.repository.AnswerRepository;
import law.advisor.repository.ContentRepository;
import law.advisor.repository.QuestionRepository;
import law.advisor.repository.UserRepository;
import law.advisor.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class AnswerController {

    @Autowired
    EntityManager entityManager;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    private EmailService emailService;

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
            Content content1=new Content();
            contentRepository.save(content1);
            answer.setContent(content1);
            model.addAttribute("questionId",questionId);
            model.addAttribute("answer",answer);
        }
        else if(answerId>0){
            Answer answer=answerRepository.getOne(answerId);
            model.addAttribute("answer",answer);
        }

        return "/answer/form";

    }

    @PostMapping("/answer/save")
    public String saveAnswer(Answer answer, String text, HttpServletRequest request){


        String appUrl= request.getScheme() + "://" + request.getServerName()+":8080";
        if(answer.getId()==null||answer.getId()==0){
            Content content=answer.getContent();
            content.setText(text);
            contentRepository.save(content);
            answer.setContent(content);
            answerRepository.save(answer);

            SimpleMailMessage answeredEmail = new SimpleMailMessage();
            answeredEmail.setFrom("saryguloveridan@gmail.com");
            answeredEmail.setTo(answer.getQuestion().getUser().getEmail());
            answeredEmail.setSubject("Your question has been answered");
            answeredEmail.setText("To see answer to your question, click the link below:\n" + appUrl
                    + "/question/" +answer.getQuestion().getId()+"/view");

            emailService.sendEmail(answeredEmail);
        }
        else if(answer.getId()>0){

            Content content1=answer.getContent();
            content1.setText(text);
            contentRepository.save(content1);
            answerRepository.save(answer);

            SimpleMailMessage answeredEmail = new SimpleMailMessage();
            answeredEmail.setFrom("saryguloveridan@gmail.com");
            answeredEmail.setTo(answer.getQuestion().getUser().getEmail());
            answeredEmail.setSubject("Your question's answer has been edited");
            answeredEmail.setText("To see editted answer to your question, click the link below:\n" + appUrl
                    + "/question/" +answer.getQuestion().getId()+"/view");

            emailService.sendEmail(answeredEmail);
        }

        return "redirect:/question/"+answer.getQuestion().getId()+"/view";
    }

    @PostMapping("/answer/{id}/delete")
    public String delete(@PathVariable("id") Long id){

        Answer answer=answerRepository.getOne(id);
        Long questionId=answer.getQuestion().getId();
        answerRepository.delete(answer);
        return "redirect: /question/"+questionId+"/view";
    }

    @GetMapping("/question/{id}/answer/{searchStr}/search")
    public String search(@PathVariable("id") long id,ModelMap model,@PathVariable("searchStr") String searchStr){

        if(searchStr.equals(" ")){
            searchStr="";
        }

        String baseQuery="select answer.*\n" +
                "from answer, content c where answer.question_id="+id+" and c.id=answer.content_id and c.text  like '%"+searchStr+"%'";
        Query query=entityManager.createNativeQuery(baseQuery,Answer.class);
        List<Answer> answers=query.getResultList();

        model.addAttribute("answers",answers);

        return "/question/answers";
    }

}
