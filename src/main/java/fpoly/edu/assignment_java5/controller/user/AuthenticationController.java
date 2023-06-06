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
import fpoly.edu.assignment_java5.service.user.SmsService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private HttpSession session;
    @Autowired
    private SmsService smsService;

    @GetMapping("/authentication")
    public String authentication(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("account", new User());
        model.addAttribute("message", "Welcome to bookstore");
        return "user/account/authentication";
    }

    @PostMapping("/sendCode")
    public ResponseEntity<?> sendCode(@RequestBody YourRequestObject requestObject, BindingResult bindingResult, Model model){
        String phoneString = requestObject.getKey1();
        if (authenticationService.findUserByTelephone(Integer.parseInt(phoneString)) != null) {
            model.addAttribute("message", "This telephone already exists!");
            return null;
        }
        String code = String.valueOf(authenticationService.generateVerificationCode());
        smsService.sendVerificationCode(authenticationService.slicePhoneNumberVietNameseFormat(phoneString), code);
        model.addAttribute("message", "This telephone is valid");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public String login_submit(@ModelAttribute("user") @Validated User user, Model model){
        int telephone = user.getTelephone();
        String password = user.getPassword();
        Boolean success = authenticationService.login(telephone, password);
        if(success){
            model.addAttribute("message", session.getAttribute("message"));
            return "redirect:/user/home";
        }
        return "redirect:/user/home";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Validated User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "register";
        }
        authenticationService.register(String.valueOf(user.getTelephone()), user.getPassword());
        session.setAttribute("message", session.getAttribute("message"));
        return "redirect:/user/home";
    }
}
