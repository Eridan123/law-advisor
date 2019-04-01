package law.advisor.controller;

import law.advisor.model.Answer;
import law.advisor.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnswerController {

    @Autowired
    AnswerRepository answerRepository;

    @RequestMapping("/answer/{id}/save")
    public String addAnswer(ModelMap model, @PathVariable("id") Long id){

        if(id==0 || id==null){
            model.addAttribute("answer",new Answer());
        }
        else if(id>0){
            Answer answer=answerRepository.getOne(id);
            model.addAttribute("answer",answer);
        }

        return "/answer/form";

    }

    @PostMapping("/answer/save")
    public String saveAnswer(Answer answer){

        if(answer.getId()==null||answer.getId()==0){
            answerRepository.save(answer);
        }
        else if(answer.getId()>0){
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
