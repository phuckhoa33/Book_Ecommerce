package fpoly.edu.assignment_java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AuthenticationController {
    @GetMapping("/login")
    public String login(Model model){
        return "user/account/authentication";
    }
}
