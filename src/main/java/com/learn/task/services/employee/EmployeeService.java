package com.learn.task.services.employee;

import java.util.List;
import com.learn.task.dto.TaskDto;

public interface EmployeeService {
    List<TaskDto> getTasksByUserId();

    TaskDto updateTask(Long id, String status);
}
