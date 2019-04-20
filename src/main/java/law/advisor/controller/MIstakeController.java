package law.advisor.controller;

import law.advisor.model.Comment;
import law.advisor.model.CommentTo;
import law.advisor.model.Content;
import law.advisor.repository.CommentRepository;
import law.advisor.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MIstakeController {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ContentRepository contentRepository;

    @GetMapping("/mistake/{id}/save")
    public String saveMistake(ModelMap model, @PathVariable("id") Long id){
        if (id==null ||id==0){
            Comment comment=new Comment();
            comment.setCommentTo(CommentTo.DEVELOPER);
            model.addAttribute("mistake",comment);
        }
        else{
            Comment comment=commentRepository.getOne(id);
            model.addAttribute("mistake",comment);
        }
        return "/technicalSupport";
    }

    @PostMapping("/mistake/save")
    public String savePostMistake(Comment comment, String text){
        if (comment.getId()==null ||comment.getId()==0){
            comment.setCommentTo(CommentTo.DEVELOPER);
            Content content=new Content();
            content.setText(text);
            contentRepository.save(content);
            comment.setContent(content);
            commentRepository.save(comment);
        }
        else{
            Comment comment1=commentRepository.getOne(comment.getId());
            comment1.getContent().setText(text);
            contentRepository.save(comment1.getContent());
        }
        return "redirect:/";
    }
}
