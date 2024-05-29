package com.blog.blog_app.Blogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("blogger/api/blog/")
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

    @GetMapping("/explore")
    public List<Blog> showBlog() {
        return service.showBlog();
    }

    @GetMapping("/user_blog/{email}/{blog_id}")
    public Optional<Blog> showMyBlog(@PathVariable String email, String blog_id) {
        return service.showMyBlog(email, blog_id);
    }
}
