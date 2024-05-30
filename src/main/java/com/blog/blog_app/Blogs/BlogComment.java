package com.blog.blog_app.Blogs;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class BlogComment {
    private UUID blog_id;
    private String commenterEmail;
    private String comment;
    private int likes;
    private String dateTime;

    public BlogComment(UUID blog_id, String commenterEmail, String comment, int likes, String dateTime) {
        this.blog_id = blog_id;
        this.commenterEmail = commenterEmail;
        this.comment = comment;
        this.likes = likes;
        this.dateTime = dateTime;
    }

    public UUID getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(UUID blog_id) {
        this.blog_id = blog_id;
    }

    public BlogComment() {}

    public String getCommenterEmail() {
        return commenterEmail;
    }

    public void setCommenterEmail(String commenterEmail) {
        this.commenterEmail = commenterEmail;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}
