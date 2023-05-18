package fpoly.edu.assignment_java5.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpoly.edu.assignment_java5.identity.User;
import fpoly.edu.assignment_java5.respository.UserRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;

    public Boolean register(String telephone, String password){
        User user = new User(); 
        user.setPassword(password);
        user.setTelephone(Integer.parseInt(telephone));        
        String message =  "Successfully registered";
        return true;
    }
    
    public void sendCode(){

    }

    public Boolean login(int telephone, String password){
        User user = userRepository.findByTelephone(telephone);
        String message = null;
        if(user==null){

            message = "This user is not exist";
            return false;
        }
        else if(!user.getPassword().equals(password)){
            message = "Password is wrong";
            return false;
        }
        message = "Login is successful";
        session.setAttribute("message", message);
        return true;
    }

    public User findUserByTelephone(int telephone){
        return userRepository.findByTelephone(telephone);
    }
}
