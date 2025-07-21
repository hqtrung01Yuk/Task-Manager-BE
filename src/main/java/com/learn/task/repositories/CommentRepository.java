package com.learn.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.task.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
