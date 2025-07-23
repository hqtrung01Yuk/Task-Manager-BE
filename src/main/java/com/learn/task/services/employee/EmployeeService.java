package com.learn.task.services.employee;

import java.util.List;
import com.learn.task.dto.CommentDto;
import com.learn.task.dto.TaskDto;

public interface EmployeeService {
    List<TaskDto> getTasksByUserId();

    TaskDto updateTask(Long id, String status);

    TaskDto getById(Long id);

    CommentDto createComment(Long taskId, String content);

    List<CommentDto> getCommentByTaskId(Long taskId);
}
