package fpoly.edu.assignment_java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    
	@GetMapping("/index")
    public String home(Model model){
        return "/user/index";  
    }
}
