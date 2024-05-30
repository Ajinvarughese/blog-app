package com.blog.blog_app.Blogs;

import jakarta.persistence.*;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID blog_id;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String blog;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ElementCollection
    private List<BlogComment> comments = new ArrayList<>();
    private String dateTime;

    public Blog(String email, String blog, String description, List<BlogComment> comments, String dateTime) {
        this.email = email;
        this.blog = blog;
        this.description = description;
        this.comments = comments;
        this.dateTime = dateTime;
    }
    public Blog(){}

    public UUID getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(UUID blog_id) {
        this.blog_id = blog_id;
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

    public List<BlogComment> getComments() {
        return comments;
    }

    public void setComments(List<BlogComment> comments) {
        this.comments = comments;
    }
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
