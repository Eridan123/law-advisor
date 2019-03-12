package law.advisor.controller;

import law.advisor.model.Category;
import law.advisor.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = {"/category","/category/list"})
    public String list(ModelMap model){
        
        List<Category> categories=categoryRepository.findAll();
        
        model.addAttribute("categories",categories);

        return "/category/list";

    }

    @RequestMapping(value = "/newCategory", method = RequestMethod.GET)
    public String newCategory(Model model) {
        Category form = new Category();
        model.addAttribute("category", form);
        return "newCategory";
    }
    
    @RequestMapping(value = {"/category/{id}/save"})
    public String getSave(ModelMap model, @PathVariable("id") Long id){

        if(id==0){
            model.addAttribute("category",new Category());
        }
        else if(id>0) {
            Category category=categoryRepository.getOne(id);
            model.addAttribute("category",category);
        }
        
        return "/category/form";
    }

}
