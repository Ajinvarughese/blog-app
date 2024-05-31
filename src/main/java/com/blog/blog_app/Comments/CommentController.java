package com.blog.blog_app.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("blogger/api/blog/comments")
public class CommentController {
    private final CommentService service;

    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping("/newComment")
    public void addNewComment(@RequestBody BlogComment comment) {
        service.newComment(comment);
    }
    @GetMapping("/comments/{blogId}")
    public List<BlogComment> showAllComments(@PathVariable UUID blogId) {
        return service.showAllComments(blogId);
    }

    @PostMapping("/deleteComment")
    public void deleteComment(@RequestBody BlogComment comment) {
        service.deleteComment(comment.getCommentId());
    }
}
