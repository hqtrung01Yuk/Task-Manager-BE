package com.learn.task.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.learn.task.dto.TaskDto;
import com.learn.task.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("""
            SELECT t
            FROM Task t
            WHERE t.title LIKE CONCAT('%', :title, '%')
            """)
    List<Task> findAllByTitleContaining(@Param("title") String title);
}
