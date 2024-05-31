package com.blog.blog_app.Blogs;

import com.blog.blog_app.Comments.BlogComment;
import com.blog.blog_app.Comments.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("blogger/api/blog")
public class BlogController {
    private final BlogService service;

    @Autowired
    public BlogController(BlogService service) {
        this.service = service;
    }

    @PostMapping("/new_blog")
    public void addNewBlog(@RequestBody Blog blog) {
        service.addNewBlog(blog);
    }

    @GetMapping("/show_everything")
    public List<Blog> showEverything() {
        return service.showEverything();
    }

    @GetMapping("/explore")
    public List<Blog> showBlog() {
        return service.showBlog();
    }

    @GetMapping("/user_blog/{blogId}")
    public Optional<Blog> showMyBlog(@PathVariable UUID blogId) {
        return service.showMyBlog(blogId);
    }
}
