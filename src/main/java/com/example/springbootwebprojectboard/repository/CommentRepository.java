package com.example.springbootwebprojectboard.repository;

import com.example.springbootwebprojectboard.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
