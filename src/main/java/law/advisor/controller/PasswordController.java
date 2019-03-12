package law.advisor.controller;


import law.advisor.model.User;
import law.advisor.repository.UserRepository;
import law.advisor.service.EmailService;
import law.advisor.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller

public class PasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    // Display forgotPassword page
    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public String displayForgotPasswordPage() {
        return "/user/reset";
    }

    // Process form submission from forgotPassword page
    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public String processForgotPasswordForm(ModelMap model, @RequestParam("email") String userEmail, HttpServletRequest request) {

        // Lookup user in database by e-mail
        User optional = userService.findUserByEmail(userEmail);

        if (optional==null) {
            model.addAttribute("errorMessage", "We didn't find an account for that e-mail address.");
        } else {

            // Generate random 36-character string token for reset password
            User user = optional;
            user.setToken(UUID.randomUUID().toString());

            // Save token to database
            userService.save(user);

            String appUrl = request.getScheme() + "://" + request.getServerName();

            // Email message
            SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
            passwordResetEmail.setFrom("saryguloveridan@gmail.com");
            passwordResetEmail.setTo(user.getEmail());
            passwordResetEmail.setSubject("Password Reset Request");
            passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
                    + "/reset?token=" + user.getToken());

            emailService.sendEmail(passwordResetEmail);

            // Add success message to view
            model.addAttribute("successMessage", "A password reset link has been sent to " + userEmail);
        }

        return "/user/successfullreset";

    }

    // Display form to reset password
    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public String displayResetPasswordPage(ModelMap model, @RequestParam("token") String token) {

        User user = userService.findUserByReset_token(token);

        if (user!=null) { // Token found in DB
            model.addAttribute("resetToken", token);
            return "/user/newpassword";
        } else { // Token not found in DB
            model.addAttribute("errorMessage", "Oops!  This is an invalid password reset link.");
            return "/user/reset";
        }

    }

    // Process reset password form
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String setNewPassword(ModelMap model,@RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        // Find the user associated with the reset token
        User user = userService.findUserByReset_token(requestParams.get("token"));

        // This should always be non-null but we check just in case
        if (user!=null) {

            User resetUser = user;

            // Set new password
            resetUser.setEncryted_password(bCryptPasswordEncoder.encode(requestParams.get("password")));

            // Set the reset token to null so it cannot be used again
            resetUser.setToken(null);

            // Save user
            userService.save(resetUser);

            // In order to set a model attribute on a redirect, we must use
            // RedirectAttributes
            redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");

            return "redirect:login";

        } else {
            model.addAttribute("errorMessage", "Oops!  This is an invalid password reset link.");
            return "user/reset";
        }

    }

    // Going to reset page without a token redirects to login page
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
        return new ModelAndView("redirect:login");
    }

    @RequestMapping(value = {"/changePassword"})
    public String getChangePassword(ModelMap model){

        User user= (User) userRepository.findUserByUsername((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("id",user.getId());
        model.addAttribute("message","");

        return "/user/changepassword";
    }

    @RequestMapping(value = {"/changePassword/{id}"})
    public String postChangePassword(@PathVariable("id") Long id, String password,ModelMap model){

        User user=userRepository.getOne(id);
        if (bCryptPasswordEncoder.encode(password)==user.getEncryted_password()){
            return "/user/cahngetonew";
        }
        else{
            model.addAttribute("message","wrong password!");
            return "/user/changepassword";
        }
    }

    @RequestMapping(value = {"/passwordchange/{id}"},method = RequestMethod.POST)
    public String completeChangePassword(@PathVariable("id") Long id,String password){

        User user=userRepository.getOne(id);
        user.setEncryted_password(bCryptPasswordEncoder.encode(password));

        return "redirect: /";
    }

}
