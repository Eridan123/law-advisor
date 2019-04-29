package law.advisor.controller;

import law.advisor.model.WebsiteRating;
import law.advisor.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RatingController {

    @Autowired
    RatingRepository ratingRepository;

    @RequestMapping(value="/rating/save", method=RequestMethod.POST)
    public String saveRating(@RequestParam("rating") int rating){
        WebsiteRating r = new WebsiteRating();
        r.setRating(rating);
        ratingRepository.save(r);
        return "redirect:/";
    }

}
