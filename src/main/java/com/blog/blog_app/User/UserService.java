package com.blog.blog_app.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void regNewUser(User user) {
        User newUser = new User(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getDob(),
                user.getProfile_image(),
                user.getReg_date());
        if (repository.findUserByEmail(newUser.getEmail()).isPresent()) {
            throw new IllegalStateException("User already exists");
        } else {
            repository.save(newUser);
        }
    }

    public List<User> showUser() {
        return repository.findAll();
    }
}
