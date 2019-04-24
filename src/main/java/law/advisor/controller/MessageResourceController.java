package law.advisor.controller;

import law.advisor.model.MessageResource;
import law.advisor.repository.MessageResourceRepository;
import law.advisor.service.MessageResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MessageResourceController {

    @Autowired
    MessageResourceRepository messageResourceRepository;

    @RequestMapping("/messageResource/list")
    public String list(ModelMap model){
        List<MessageResource> list=messageResourceRepository.findAll();
        model.addAttribute("list",list);
        return null;
    }

    @RequestMapping("/messageResource/{id}/save")
    public String getSave(ModelMap model, @PathVariable("id") Long id){
        if(id==null || id==0){
            model.addAttribute("messageResource",new MessageResource());
        }
        else{
            model.addAttribute("messageResource",messageResourceRepository.getOne(id));
        }
        return null;
    }

    @PostMapping("/messageResource/save")
    public String postSave(MessageResource messageResource){
        if(messageResource.getId()==0){
            messageResourceRepository.save(messageResource);
        }
        else{
            messageResourceRepository.save(messageResource);
        }
        return null;
    }
}
