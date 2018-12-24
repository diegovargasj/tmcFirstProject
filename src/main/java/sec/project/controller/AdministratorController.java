package sec.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sec.project.domain.User;
import sec.project.repository.UserRepository;

@Controller
@RequestMapping(AdministratorController.BASE_URL)
public class AdministratorController {
    
    public static final String BASE_URL = "admin";
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping("")
    public String adminLogin() {
        return "admin";
    }
    
    @RequestMapping("/{query}")
    public String query(Model model, @PathVariable String query) {
        try {
            List<User> users = userRepository.query(query);
            users.forEach((user) -> {
                model.addAttribute(user.toString());
            });
        } catch (Exception e) {
            
        }
        return "admin";
    }
    
}
