package com.learn.task.services.admin.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.learn.task.dto.TaskDto;
import com.learn.task.dto.UserDto;
import com.learn.task.entities.Task;
import com.learn.task.entities.User;
import com.learn.task.enums.TaskStatus;
import com.learn.task.enums.UserRole;
import com.learn.task.repositories.TaskRepository;
import com.learn.task.repositories.UserRepository;
import com.learn.task.services.admin.AdminService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .filter(user -> user.getUserRole() == UserRole.EMPLOYEE).map(User::getUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        return userRepository.findById(taskDto.getEmployeeId()).map(user -> {
            Task task = new Task();
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setDueDate(taskDto.getDueDate()); // fixed!
            task.setPriority(taskDto.getPriority());
            task.setTaskStatus(TaskStatus.INPROCESS);
            task.setUser(user);
            logger.info("User found with name: {}", user.getName());
            return taskRepository.save(task).getTaskDto();
        }).orElseThrow(() -> {
            logger.warn("User not found with name: " + taskDto.getEmployeeName());
            return new EntityNotFoundException("User not found");
        });
    }

    @Override
    public List<TaskDto> getAllTask() {
        return taskRepository.findAll().stream()
                .sorted(Comparator.comparing(Task::getDueDate).reversed()).map(Task::getTaskDto)
                .collect(Collectors.toList());
    }
}
