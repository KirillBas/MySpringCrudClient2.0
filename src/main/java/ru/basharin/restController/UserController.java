package ru.basharin.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.basharin.restModel.RestUser;
import ru.basharin.restService.UserService;
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/rest/user/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseBody
    public ResponseEntity<RestUser> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping(value = "/rest/user")
    public String getUser(Model model) {
        RestUser user = (RestUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long id = user.getId();
        model.addAttribute("current_user", userService.getUserById(id));
        return "user";
    }
}
