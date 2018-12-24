package sec.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.User;
import sec.project.repository.UserRepository;

@Controller
@RequestMapping(SignupController.BASE_URL)
public class SignupController {
    
    public static final String BASE_URL = "signup";

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public String signUpMapping() {
        return "signup";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String submitForm(@RequestParam String username, 
            @RequestParam String email, 
            @RequestParam String password) {
        System.out.println("Requesting signup: " + username);
        List<User> u = userRepository.findByEmail(email);
        if (!u.isEmpty()) {
            System.out.println("Trying to signup with already used email");
            return "redirect:/signup";
        }
        userRepository.save(new User(username, email, password));
        System.out.println("Saved. Count: " + userRepository.count());
        return "redirect:/";
    }
}
