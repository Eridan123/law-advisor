package law.advisor.controller;

import law.advisor.model.*;
import law.advisor.repository.RoleRepository;
import law.advisor.repository.LawyerRepository;
import law.advisor.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;


    @RequestMapping("/lawyer/list")
    public String list(ModelMap model){

        UserType userType=UserType.LAWYER;
        List<User> lawyers=userService.findByUserType(userType);

        model.addAttribute("lawyers",lawyers);

        return "/lawyer/list";
    }

    @RequestMapping("/lawyer/{id}/save")
    public String add(ModelMap model,@PathVariable("id") Long id){

        if(id==null||id<=0){
            User lawyer=new User();
            lawyer.setUserType(UserType.LAWYER);
            model.addAttribute("lawyer",lawyer);
        }
        else{
            User lawyer=userRepository.getOne(id);
            model.addAttribute("lawyer",lawyer);
        }




        return "/lawyer/form";
    }

    @RequestMapping("/lawyer/{id}/view")
    public String view(ModelMap model,@PathVariable("id") Long id){

        User lawyer=userRepository.getOne(id);

        model.addAttribute("lawyer",lawyer);

        return "/lawyer/view";
    }


    @RequestMapping("/lawyer/top")
    public String tops(ModelMap model){

        List<LawyerRateModel> list=userService.findTopLawyers(10);

        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("lawyers",list);

        return "/lawyer/top";
    }

    @RequestMapping("/lawyer/{period}/active")
    public String activeLawyers(ModelMap model,@PathVariable("period") String period){

        List<LawyerRateModel> list=userService.findActiveLawyersByPeriod(10);
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("lawyers",list);
        return "/lawyer/active";
    }

    @PostMapping("/lawyer/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        User lawyer=userRepository.getOne(id);
        userRepository.delete(lawyer);

        return "redirect: /lawyer/list";
    }

}
