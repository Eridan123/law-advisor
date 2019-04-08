package law.advisor.controller;

import law.advisor.model.*;
import law.advisor.repository.*;
import law.advisor.service.CategoryService;
import law.advisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LawyerController {

    @Autowired
    ContentRepository contentRepository;

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

    @Autowired
    EntityManager entityManager;


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
            model.addAttribute("content",new Content());
            model.addAttribute("lawyer",lawyer);
        }
        else{
            User lawyer=userRepository.getOne(id);
            model.addAttribute("content",lawyer.getLawyer_degree_id());
            model.addAttribute("lawyer",lawyer);
        }




        return "/lawyer/form";
    }

    @PostMapping("/lawyer/save")
    public String  save(ModelMap model,User lawyer,String content,String optionsRadios){

        if (optionsRadios.equals("option1")){
            lawyer.setGender(1);
        }
        else{
            lawyer.setGender(2);
        }
        if(lawyer.getId()==null){
            Role role=roleRepository.getOne(Long.valueOf(2));
            UserRole userRole=new UserRole();
            userRole.setRole(role);
            Content content1=new Content();
            content1.setText(content);
            userRole.setUser(lawyer);
            contentRepository.save(content1);
            lawyer.setLawyer_degree_id(content1);
            lawyer.setEncryted_password(bCryptPasswordEncoder.encode(lawyer.getEncryted_password()));
            userRepository.save(lawyer);
            userRoleRepository.save(userRole);

        }

        else if(lawyer.getId()>0){

            User lawyer1=userRepository.getOne(lawyer.getId());
            Content content1=lawyer1.getLawyer_degree_id();
            content1.setText(content);
            contentRepository.save(content1);
            lawyer1.setEmail(lawyer.getEmail());
            lawyer1.setName(lawyer.getName());
            lawyer1.setPhone_number(lawyer.getPhone_number());
            lawyer1.setSurname(lawyer.getSurname());

            userRepository.save(lawyer1);
        }

        return "redirect:/lawyer/"+lawyer.getId()+"/view";
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

    @GetMapping("/lawyer/{searchStr}/search")
    public String search(@PathVariable(value = "searchStr",required = false) String searchStr,ModelMap model){

        if(searchStr.equals(" ")){
            searchStr="";
        }
        String baseQuery="select *\n" +
                "from user u where u.user_type='LAWYER' and (u.name like '%"+searchStr+"%' or \n" +
                "                  u.surname like '%"+searchStr+"%' or \n" +
                "                  u.username like '%"+searchStr+"%')";
        Query query=entityManager.createNativeQuery(baseQuery,User.class);
        List<User> users=query.getResultList();

        model.addAttribute("users",users);

        return "/lawyer/lawyers";
    }

}
