package fpoly.edu.assignment_java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("home")
    public String home(Model model){
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "home";
    }
}
