package law.advisor.controller;

import law.advisor.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

    @Autowired
    CategoryRepository categoryRepository;


    @RequestMapping("/reviews")
    public String reviewsPage(ModelMap model){

        model.addAttribute("categories",categoryRepository.findAll());

        return "/reviews";
    }

}
