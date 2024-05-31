package com.blog.blog_app.Comments;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class BlogComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID commentId;
    private UUID blogId;
    private String commenterEmail;
    private String comment;
    private int likes;
    private String dateTime;

    public BlogComment(UUID blogId, String commenterEmail, String comment, int likes, String dateTime) {
        this.blogId = blogId;
        this.commentId = UUID.randomUUID();
        this.commenterEmail = commenterEmail;
        this.comment = comment;
        this.likes = likes;
        this.dateTime = dateTime;
    }

    public UUID getBlogId() {
        return blogId;
    }

    public void setBlogId(UUID blogId) {
        this.blogId = blogId;
    }

    public UUID getCommentId() {
        return commentId;
    }

    public void setCommentId(UUID commentId) {
        this.commentId = commentId;
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
