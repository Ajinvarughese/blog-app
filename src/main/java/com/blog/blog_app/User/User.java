package com.blog.blog_app.User;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String username;
    @Column(nullable = false)
    private String email;
    private String password;
    private String dob;
    private byte[] profileImage;
    private String regDateTime;

    public User(){}

    public User(String username, String email, String password, String dob, byte[] profileImage, String regDateTime) {
        this.username = username;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.dob = dob;
        this.profileImage = profileImage;
        this.regDateTime = regDateTime;
    }


    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public String getRegDateTime() {
        return regDateTime;
    }

    public void setRegDateTime(String regDateTime) {
        this.regDateTime = regDateTime;
    }
}
