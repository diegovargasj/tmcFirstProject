package sec.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.User;
import sec.project.repository.LoginRepository;

@Controller
public class LoginController {
    
    private static final String adminEmail = "admin@admin.com";
    private static final String adminPassword = "admin";
    
    @Autowired
    private LoginRepository loginRepository;
    
    @RequestMapping("/")
    public String defaultMapping(Model model) {
        model.addAttribute("error", "");
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitLoginForm(@RequestParam String email, Model model,
            @RequestParam String password) {
        System.out.println("Requesting login: " + email + " - " + password);
        if (email.equals(adminEmail) && password.equals(adminPassword)) {
            System.out.println("Admin logged in");
            return "redirect:/admin";
        }
        List<User> u = loginRepository.findLogin(email, password);
        if (u.isEmpty()) {
            System.out.println("No user found");
            model.addAttribute("error", "Username or password incorrect");
            return "redirect:/";
        }
        System.out.println("User found: " + u.get(0).getUsername());
        return "redirect:user/" + u.get(0).getUsername();
    }
    
}
