package com.blog.blog_app.Blogs;

import com.blog.blog_app.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogService {
    private final BlogRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public BlogService(BlogRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public void addNewBlog(Blog blog) {
        Blog newBlog = new Blog(
                blog.getEmail(),
                blog.getBlog(),
                blog.getDescription(),
                blog.getComments(),
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


    public void updateComment(BlogComment newComment) {
        BlogComment comments1 = new BlogComment(newComment.getBlog_id(), newComment.getCommenterEmail(), newComment.getComment(), newComment.getLikes(), newComment.getDateTime());
        // Fetch the blog entity by ID
        Optional<Blog> blogOpt = repository.findById(comments1.getBlog_id());

        if (blogOpt.isPresent()) {
            Blog blog = blogOpt.get();

            // Retrieve the existing comments, initialize if null or empty
            List<BlogComment> comments = blog.getComments();
            if (comments == null) {
                comments = new ArrayList<>();
            }

            // Add the new comment to the list of existing comments
            comments.add(comments1);

            // Set the updated list of comments
            blog.setComments(comments);

            // Save the updated blog entity
            repository.save(blog);
        }else {
            throw new IllegalStateException("Blog does not found");
        }
    }

    public List<Blog> showEverything() {
        return repository.findAll();
    }
}
