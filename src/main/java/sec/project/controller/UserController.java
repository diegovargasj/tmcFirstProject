package sec.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.User;
import sec.project.repository.UserRepository;

@Controller
@RequestMapping(UserController.BASE_URL)
public class UserController {
    
    public static final String BASE_URL = "user";
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(value = "/{username}")
    public String userMapping(Model model, @PathVariable String username) {
        List<User> u = userRepository.findByUsername(username);
        if (u.isEmpty()) {
            return "loginError";
        }
        model.addAllAttributes(u.get(0).getAttributes());
        return "user";
    }
    
    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public String secretMessageForm(@RequestParam String message, 
            @PathVariable String username) {
        System.out.println("Request to change secret message: " + username);
        List<User> u = userRepository.findByUsername(username);
        if (u.isEmpty()) {
            System.out.println("User not found");
            return "error";
        }
        u.get(0).setSecretMessage(message);
        System.out.println("Secret message changed: " + message);
        return "redirect:" + BASE_URL + "/" + username;
    }
}
