package law.advisor.controller;

import law.advisor.model.Role;
import law.advisor.model.User;
import law.advisor.model.UserRole;
import law.advisor.repository.CategoryRepository;
import law.advisor.repository.RoleRepository;
import law.advisor.repository.UserRepository;
import law.advisor.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/category")
    public String category(ModelMap model){
        model.addAttribute("category",new User());

        return "/category";

    }



}
