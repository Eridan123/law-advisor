package law.advisor.controller;

import law.advisor.model.MessageResource;
import law.advisor.repository.MessageResourceRepository;
import law.advisor.service.MessageResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Controller
public class MessageResourceController {

    @Autowired
    MessageResourceRepository messageResourceRepository;

    @Autowired
    EntityManager entityManager;

    @RequestMapping("/messageResource/list")
    public String list(ModelMap model){

        model.addAttribute("message",new MessageResource());
        return "/messageresource/list";
    }

    @RequestMapping("/messageResource/{id}/save")
    public String getSave(ModelMap model, @PathVariable("id") Long id){
        if(id==null || id==0){
            model.addAttribute("message",new MessageResource());
        }
        else{
            model.addAttribute("message",messageResourceRepository.getOne(id));
        }
        return "/messageresource/form";
    }

    @PostMapping("/messageResource/save")
    public String postSave(MessageResource messageResource){
        messageResourceRepository.save(messageResource);
        return "redirect:/messageResource/list";
    }

    @GetMapping("/message/{searchStr}/search")
    public String search(@PathVariable("searchStr") String searchStr,ModelMap model){
        String baseQuesry="select * from message_resource where \n" +
                "(message_key like '%"+searchStr+"%')\n" +
                "or (kgz like '%"+searchStr+"%') or (rus like '%"+searchStr+"%') or (eng like '%"+searchStr+"%')";

        Query query=entityManager.createNativeQuery(baseQuesry,MessageResource.class);
        List<MessageResource> list=query.getResultList();

        model.addAttribute("list",list);

        return "/messageresource/resources";
    }

    @PostMapping("/messageResource/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        MessageResource messageResource=messageResourceRepository.getOne(id);
        messageResourceRepository.delete(messageResource);
        return "redirect:/messageResource/list";
    }
}
