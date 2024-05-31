package com.blog.blog_app.Blogs;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID blogId;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String blog;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String dateTime;

    @Autowired
    public Blog(String email, String blog, String description, String dateTime) {
        this.email = email;
        this.blog = blog;
        this.description = description;
        this.dateTime = dateTime;
    }

    public Blog() {}

    public UUID getBlogId() {
        return blogId;
    }

    public void setBlogId(UUID blogId) {
        this.blogId = blogId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
