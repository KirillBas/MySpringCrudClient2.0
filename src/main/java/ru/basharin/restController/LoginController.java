package ru.basharin.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.basharin.restService.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/login")
    public ModelAndView loginFine(@ModelAttribute("name") String name, @ModelAttribute("password") String pass) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/rest/admin/users");
        modelAndView.addObject("temp_user", userService.authUser(name, pass));
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
