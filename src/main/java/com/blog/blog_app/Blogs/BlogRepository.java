package com.blog.blog_app.Blogs;

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
    @Query("SELECT s FROM Blog s WHERE s.blog_id = ?1")
    Optional<Blog> findBlogById( UUID blog_id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Blog s WHERE s.email = ?1 AND s.blog_id = ?2")
    void deleteById(String email, UUID blog_id);

    @Query("SELECT b.comments FROM Blog b WHERE b.id = :blogId")
    Optional<List<BlogComment>>  findCommentsByBlogId(@Param("blogId") UUID blogId);
}
