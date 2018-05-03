package com.polytech.web;

import com.polytech.services.User;
import com.polytech.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    private UserService userService ;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String registerPage() {
        return "register" ;
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String register(String username, String password) {
        System.out.println(new User(username, password)) ;
        return "login" ;
    }
}
