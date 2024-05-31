package com.blog.blog_app.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
                user.getProfileImage(),
                user.getRegDateTime());
        if (repository.findUserByEmail(newUser.getEmail()).isPresent()) {
            throw new IllegalStateException("User already exists");
        } else {
            repository.save(newUser);
        }
    }


    public List<User> showUser() {
        return repository.findAll();
    }

    public User login(String email, String password) {
        User user = repository.findUserByEmailLogin(email);

        if(user == null) {
            throw new IllegalStateException("user does not exists");
        }

        if(!password.equals(user.getPassword())) {
            throw new IllegalStateException("Email or password is incorrect");
        }

        return user;
    }
}
