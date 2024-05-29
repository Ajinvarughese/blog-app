package com.blog.blog_app.Blogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("SELECT s FROM Blog s WHERE s.email = ?1 AND s.blog_id = ?2")
    Optional<Blog> findBlogByEmailAndId(String email, String blog_id);
}
