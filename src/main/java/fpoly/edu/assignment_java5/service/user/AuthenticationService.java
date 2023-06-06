package fpoly.edu.assignment_java5.service.user;

import java.util.Random;

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

    public Boolean register(String email, String password){
        User user = new User(); 
        System.out.println(email+password);
        user.setPassword(password);
        user.setEmail(email);      
        session.setAttribute("user", user);
        userRepository.save(user);
        return true;
    }

    public String slicePhoneNumberVietNameseFormat(String phoneString){
        String phoneVietNameseString = "+84"+phoneString;
        return phoneVietNameseString;
    }
    
    public int generateVerificationCode(){
        // Create an instance of Random class
        Random random = new Random();

        // Generate a random integer between 0 and 9 (inclusive)
        int randomNumber = random.nextInt(900000) + 100000;
        return randomNumber;
    }

    public void sendCode(){

    }

    public Boolean login(String email, String password){
        User user = userRepository.findByEmail(email);
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

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
