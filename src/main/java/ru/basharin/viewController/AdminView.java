package ru.basharin.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminView {

    @RequestMapping(value = "/rest/admin/users")
    public String index() {
        return "users";
    }
}
