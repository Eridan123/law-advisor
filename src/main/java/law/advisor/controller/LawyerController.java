package law.advisor.controller;

import law.advisor.model.LawyerRateModel;
import law.advisor.model.Role;
import law.advisor.model.User;
import law.advisor.model.UserRole;
import law.advisor.repository.RoleRepository;
import law.advisor.repository.LawyerRepository;
import law.advisor.repository.UserRoleRepository;
import law.advisor.service.CategoryService;
import law.advisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LawyerController {

    @Autowired
    LawyerRepository lawyerRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/lawyer/top")
    public String tops(ModelMap model){

        List<LawyerRateModel> list=userService.findTopLawyers(10);

        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("lawyers",list);

        return "/lawyer/top";
    }
}
