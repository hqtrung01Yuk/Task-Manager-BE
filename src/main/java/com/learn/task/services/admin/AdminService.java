package com.learn.task.services.admin;

import java.util.List;
import com.learn.task.dto.TaskDto;
import com.learn.task.dto.UserDto;

public interface AdminService {
    List<UserDto> getUsers();

    TaskDto createTask(TaskDto taskDto);
}
