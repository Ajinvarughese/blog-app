package com.blog.blog_app.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {
    private final BlogCommentsRepo repository;

    @Autowired
    public CommentService(BlogCommentsRepo repository) {
        this.repository = repository;
    }

    public void newComment(BlogComment comment) {
        repository.save(comment);
    }
    public List<BlogComment> showAllComments(UUID blogId) {
        return repository.findAllByBlogId(blogId);
    }

    public void deleteComment(UUID commentId) {
        repository.deleteById(commentId);
    }

}
