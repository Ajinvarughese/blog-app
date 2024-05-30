package com.blog.blog_app.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("blogger/api/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/showUsers")
    public List<User> showUsers() {
        return service.showUser();
    }

    @PostMapping("/signup")
    public void regNewUser(@RequestBody User user) {
        service.regNewUser(user);
    }
}
