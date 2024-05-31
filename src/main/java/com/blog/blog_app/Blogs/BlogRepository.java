package com.blog.blog_app.Blogs;

import com.blog.blog_app.Comments.BlogComment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BlogRepository extends JpaRepository<Blog, UUID> {

    @Query("SELECT s FROM Blog s WHERE s.email = ?1")
    Optional<Blog> findUserByEmail(String email);

    @Query("SELECT s FROM Blog s WHERE s.blogId = ?1")
    Optional<Blog> findBlogById(UUID blogId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Blog s WHERE s.email = ?1 AND s.blogId = ?2")
    void deleteById(String email, UUID blogId);

}
