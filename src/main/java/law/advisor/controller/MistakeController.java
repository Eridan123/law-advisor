package law.advisor.controller;

import law.advisor.model.*;
import law.advisor.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class MistakeController {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    AnswerRepository answerRepository;

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
        if(ratingRepository.findAll() == null){
            model.addAttribute("rating",5);
        }
        else{
            int sum=0;
            int c = 0;
            for (WebsiteRating r:ratingRepository.findAll()) {
                sum +=r.getRating();
                c=c+1;
            }
            model.addAttribute("rating", sum/c);
        }
        return "/technicalSupport";
    }

    @PostMapping("/mistake/save")
    public String savePostMistake(Comment comment, String text){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (comment.getId()==null ||comment.getId()==0){
            comment.setCommentTo(CommentTo.DEVELOPER);
            Content content=new Content();
            content.setText(text);
            contentRepository.save(content);
            comment.setContent(content);

            Date date = new Date();
            comment.setDate(date);

            User user=userRepository.findUserByUsername(auth.getName());
            comment.setUser(user);

            comment.setAnswer(answerRepository.getOne((long) 1));

            commentRepository.save(comment);
        }
        else{
            Comment comment1=commentRepository.getOne(comment.getId());
            comment1.getContent().setText(text);
            contentRepository.save(comment1.getContent());
        }
        return "redirect:/";
    }

    @GetMapping("/mistake/list")
    public String mistakeList(ModelMap model){
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"date"));
        List<Comment> comments = commentRepository.findAllByCommentTo(CommentTo.DEVELOPER,sort);

        model.addAttribute("comments",comments);

        return "/admin/FAQ";
    }

}
