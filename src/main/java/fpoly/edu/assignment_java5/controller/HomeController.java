package fpoly.edu.assignment_java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class HomeController {
    @GetMapping("/home")
    public String home(Model model){
        return "user/index";  
    }

    @GetMapping("/cart")
    public String cart(){
        return "user/cart";
    }
}
