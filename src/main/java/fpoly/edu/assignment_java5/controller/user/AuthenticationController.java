package fpoly.edu.assignment_java5.controller.user;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpoly.edu.assignment_java5.identity.User;
import fpoly.edu.assignment_java5.service.user.AuthenticationService;

@Controller
@RequestMapping("/user")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/login")
    public String login(Model model){
        return "user/account/authentication";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Validated User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (authenticationService.findUserByTelephone(user.getTelephone()) != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
            return "register";
        }
        String message = authenticationService.register(null, null);
        model.addAttribute("message", message);
        return "redirect:/home";
    }
=======
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class AuthenticationController {
    @GetMapping("/authentication")
    public String login(Model model){
        return "user/account/authentication";
    }
>>>>>>> remotes/origin/UI_UX_design
}
