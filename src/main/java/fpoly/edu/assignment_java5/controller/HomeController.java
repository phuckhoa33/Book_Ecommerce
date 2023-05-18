package fpoly.edu.assignment_java5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("home")
public class HomeController {
    @Autowired
    private HttpSession session;

    @GetMapping("index")
    public String home(Model model){
        model.addAttribute("message", session.getAttribute("message"));
        return "user/home";  
    }
}
