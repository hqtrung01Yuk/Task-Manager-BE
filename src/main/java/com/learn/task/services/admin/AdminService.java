package com.learn.task.services.admin;

import java.util.List;
import com.learn.task.dto.CommentDto;
import com.learn.task.dto.TaskDto;
import com.learn.task.dto.UserDto;

public interface AdminService {
    List<UserDto> getUsers();

    TaskDto createTask(TaskDto taskDto);

    List<TaskDto> getAllTask();

    void deleteTask(Long id);

    TaskDto getById(Long id);

    TaskDto updateTask(Long id, TaskDto taskDto);

    List<TaskDto> searchTaskByTitle(String title);

    CommentDto createComment(Long taskId, String content);
}
