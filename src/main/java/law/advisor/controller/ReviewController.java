package law.advisor.controller;

import law.advisor.model.Comment;
import law.advisor.model.CommentTo;
import law.advisor.model.Content;
import law.advisor.model.User;
import law.advisor.repository.CategoryRepository;
import law.advisor.repository.CommentRepository;
import law.advisor.repository.ContentRepository;
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
public class ReviewController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping("/reviews")
    public String reviewsPage(ModelMap model){

        model.addAttribute("categories",categoryRepository.findAll());

        return "reviews";
    }


//    save review for lawyer
    @PostMapping("/review/lawyer/{lawyerId}/save")
    public String saveLawyerReview(@PathVariable("lawyerId") Long lawyerId,String text){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getName()!=null){
            User user=userRepository.findUserByUsername(auth.getName());
            Comment review=new Comment();
            review.setCommentTo(CommentTo.LAWYER);
            Content content=new Content();
            content.setText(text);
            contentRepository.save(content);
            review.setContent(content);
            review.setUser(user);
            review.setDate(new Date());
            User lawyer=userRepository.getOne(lawyerId);
            review.setLawyer(lawyer);
            commentRepository.save(review);

        }

        return "redirect:lawyer/"+lawyerId+"/view";
    }

}
