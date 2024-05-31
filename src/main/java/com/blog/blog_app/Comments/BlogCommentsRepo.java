package com.blog.blog_app.Comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BlogCommentsRepo extends JpaRepository<BlogComment, UUID> {

    @Query("SELECT b FROM BlogComment b WHERE b.blogId = :blogId")
    List<BlogComment> findAllByBlogId(@Param("blogId") UUID blogId);
}
