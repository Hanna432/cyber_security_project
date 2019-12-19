package sec.project.controller;

import dao.UserDao;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;

@Controller
public class SignupController {
    
    private UserDao userDao = new UserDao();

    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(Model model, @RequestParam String username, @RequestParam String password) throws SQLException{
        
        Signup user = userDao.read(username);
        
        if (user == null) {
            userDao.save(username, password);
            return "done";
        }
        if (user.getPassword().equals(password)) {
            model.addAttribute("username", "Your username is: " + username);
            model.addAttribute("password", "Your password is: " + password);
            return "loggedIn";
        }
        return "form";
    }
    
    

}
