package fpoly.edu.assignment_java5.controller.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fpoly.edu.assignment_java5.identity.User;
import fpoly.edu.assignment_java5.object.YourRequestObject;
import fpoly.edu.assignment_java5.service.user.AuthenticationService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private HttpSession session;

    @GetMapping("/authentication")
    public String authentication(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("account", new User());
        model.addAttribute("message", "Welcome to bookstore");
        return "user/account/authentication";
    }

    @PostMapping("/sendCode")
    public ResponseEntity<?> sendCode(@RequestBody YourRequestObject requestObject, BindingResult bindingResult, Model model){
        String email = requestObject.getKey1();

        if (authenticationService.findUserByEmail(email) != null) {
            return ResponseEntity.badRequest().build();
        }

        String code = String.valueOf(authenticationService.generateVerificationCode());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public String login_submit(@ModelAttribute("user") @Validated User user, Model model){
        String email = user.getEmail();
        String password = user.getPassword();
        Boolean success = authenticationService.login(email, password);
        if(success){
            model.addAttribute("message", session.getAttribute("message"));
            return "redirect:/home/index";
        }
        return "redirect:/home/index";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Validated User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "register";
        }
        authenticationService.register(String.valueOf(user.getEmail()), user.getPassword());
        session.setAttribute("message", session.getAttribute("message"));
        return "redirect:/home/index";
    }
}
