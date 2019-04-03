package law.advisor.controller;

import law.advisor.model.Role;
import law.advisor.model.User;
import law.advisor.model.UserRole;
import law.advisor.repository.RoleRepository;
import law.advisor.repository.UserRepository;
import law.advisor.repository.UserRoleRepository;
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
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/signup")
    public String signup(ModelMap model){
        model.addAttribute("user",new User());

        return "/signup";
    }

    @PostMapping("/signup")
    public String signupPost(ModelMap model,User user){

        userRepository.save(user);
        return "redirect : /login";
    }

    @RequestMapping("/login")
    public String login(ModelMap model){

        return "/login";
    }

    @RequestMapping({"/user","/user/list"})
    public String list(ModelMap model){


        model.addAttribute("users",userRepository.findAll());
        return "/user/list";
    }

    @RequestMapping("/user/{userId}/view")
    public String  view(ModelMap model, @PathVariable("userId") Long userId){

        User user=userRepository.getOne(userId);
        List<UserRole> userRoles=userRoleRepository.findAllByUser(user);

        model.addAttribute("user",user);
        model.addAttribute("role",userRoles.get(0));

        return "/user/view";
    }

    @RequestMapping("/user/{userId}/save")
    public String  userForm(ModelMap model, @PathVariable("userId") Long userId){

        if(userId==0){

            model.addAttribute("user",new User());
        }

        else if(userId>0){
            User user=userRepository.getOne(userId);

            model.addAttribute("user",user);
        }

        return "user/form";
    }

    @PostMapping("/user/save")
    public String  save(ModelMap model,User user,String optionsRadios){

        if (optionsRadios.equals("option1")){
            user.setGender(1);
        }
        else{
            user.setGender(2);
        }
        if(user.getId()==null){
            user.setEncryted_password(bCryptPasswordEncoder.encode(user.getEncryted_password()));
            Role role=roleRepository.getOne(Long.valueOf(3));
            UserRole userRole=new UserRole();
            userRole.setRole(role);
            userRole.setUser(user);
            userRepository.save(user);
            userRoleRepository.save(userRole);

        }

        else if(user.getId()>0){

            User user1=userRepository.getOne(user.getId());
            user1.setEmail(user.getEmail());
            user1.setName(user.getName());
            user1.setPhone_number(user.getPhone_number());
            user1.setSurname(user.getSurname());

            userRepository.save(user1);
        }

        return "redirect:/user/"+user.getId()+"/view";
    }

    @PostMapping("/user/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id,ModelMap model){
        User user=userRepository.getOne(id);

        userRepository.delete(user);

        model.addAttribute("success","Account successfully deleted");
        return "redirect:/";
    }
}
