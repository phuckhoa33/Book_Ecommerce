package fpoly.edu.assignment_java5.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpoly.edu.assignment_java5.identity.User;
import fpoly.edu.assignment_java5.respository.UserRepository;

@Service
public class AuthenticationService {
    @Autowired
    UserRepository userRepository;

    public String register(String telephone, String password){
        User user = new User(); 
        user.setPassword(password);
        user.setTelephone(Integer.parseInt(telephone));        
        System.out.println(user);
        return "Successfully registered";
    }

    public String login(String username, String password){
        return "Login is successful";
    }

    public User findUserByTelephone(int telephone){
        return userRepository.findByTelephone(telephone);
    }
}
