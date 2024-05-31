package com.blog.blog_app.Blogs;

import com.blog.blog_app.Comments.BlogComment;
import com.blog.blog_app.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogService {
    private final BlogRepository repository;
    private final UserRepository userRepository;

//    private final BlogCommentsRepo commentsRepo;

    @Autowired
    public BlogService(BlogRepository repository, UserRepository  userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;

    }

    public void addNewBlog(Blog blog) {
        Blog newBlog = new Blog(
                blog.getEmail(),
                blog.getBlog(),
                blog.getDescription(),
                blog.getDateTime()
        );
        if(userRepository.findUserByEmail(newBlog.getEmail()).isPresent()) {
            repository.save(newBlog);
        }else {
            throw new IllegalStateException("User should login");
        }
    }

    public Optional<Blog> findMyBlog(UUID blog_id) {
        return repository.findBlogById(blog_id);
    }

    public void deleteMyBlog(UUID blog_id) {
        if(repository.findBlogById(blog_id).isPresent()) {
            repository.deleteById(blog_id);
        }else {
            throw new IllegalStateException("No blog was found");
        }
    }

    public List<Blog> showBlog() {
        return repository.findAll();
    }

    public Optional<Blog> showMyBlog(UUID blog_id) {
        Optional<Blog> myBlog = repository.findBlogById(blog_id);
        if(myBlog.isPresent()) {
            return myBlog;
        }else {
            throw new IllegalStateException("Can't find blog 404 error");
        }
    }

    public List<Blog> showEverything() {
        return repository.findAll();
    }

}
