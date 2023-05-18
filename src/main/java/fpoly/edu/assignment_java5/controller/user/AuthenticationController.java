package fpoly.edu.assignment_java5.controller.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import fpoly.edu.assignment_java5.identity.User;
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
        model.addAttribute("message", session.getAttribute("message"));
        return "user/account/authentication";
    }

    @PostMapping("/sendCode")
    public void sendCode(Model model){
        String code = generateVerificationCode();
        model.addAttribute("code", code);
        smsService.sendVerificationCode("+84972495038", code);
    }

    private String generateVerificationCode(){
        UUID uuid = UUID.randomUUID();
        String code = uuid.toString().replaceAll("-", "").substring(0, 6);
        return code;
    }

    @PostMapping("/login")
    public String login_submit(@ModelAttribute("user") @Validated User user, Model model){
        int telephone = user.getTelephone();
        String password = user.getPassword();
        System.out.println(telephone);
        Boolean success = authenticationService.login(telephone, password);
        if(success){
            model.addAttribute("message", session.getAttribute("message"));
            return "redirect:/home/index";
        }
        return "user/account/authentication";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Validated User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (authenticationService.findUserByTelephone(user.getTelephone()) != null) {
            bindingResult.rejectValue("email", "error.user", "This telephone already exists!");
            return "register";
        }
        session.setAttribute("message", session.getAttribute("message"));
        return "redirect:/home";
    }
}
