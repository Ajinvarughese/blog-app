package com.blog.blog_app.Blogs;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class BlogService {
    private final BlogRepository repository;

    @Autowired
    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }

    public void addNewBlog(Blog blog) {
        Blog newBlog = new Blog(
                blog.getUser_id(),
                blog.getEmail(),
                blog.getBlog(),
                blog.getDateTime()
        );
        repository.save(newBlog);
    }

    public List<Blog> showBlog() {
        return repository.findAll();
    }

    public Optional<Blog> showMyBlog(String email, String blog_id) {
        Optional <Blog> myBlog = repository.findBlogByEmailAndId(email, blog_id);
        if(myBlog.isPresent()) {
            return myBlog;
        }else {
            throw new IllegalStateException("Can't find blog 404 error");
        }
    }
}
