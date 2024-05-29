package com.blog.blog_app.Blogs;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID blog_id;
    private String user_id;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String blog;
    private String dateTime;

    public Blog(String user_id, String email, String blog, String dateTime) {
        this.user_id = user_id;
        this.email = email;
        this.blog = blog;
        this.dateTime = dateTime;
    }
    public Blog(){}

    public UUID getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(UUID blog_id) {
        this.blog_id = blog_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
