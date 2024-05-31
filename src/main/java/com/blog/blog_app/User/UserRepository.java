package com.blog.blog_app.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT s FROM User s WHERE s.userId=?1")
    Optional<User> findUserById(String id);

    @Query("SELECT s FROM User s WHERE s.email=?1")
    Optional<User> findUserByEmail(String email);

    @Query("SELECT s FROM User s WHERE s.email = :email")
    User findUserByEmailLogin(@Param("email") String email);

    @Query("SELECT s FROM User s WHERE s.email = ?1 AND s.userId = ?2")
    Optional<User> findBlogByEmailAndId(String email, UUID userId);
}
