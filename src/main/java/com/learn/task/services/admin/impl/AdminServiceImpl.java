package com.learn.task.services.admin.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .filter(user -> user.getUserRole() == UserRole.EMPLOYEE).map(User::getUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Optional<User> optionalUser = userRepository.findById(taskDto.getEmployeeId());
        if (optionalUser.isPresent()) {
            Task task = new Task();
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setDueDate(task.getDueDate());
            task.setPriority(taskDto.getPriority());
            task.setTaskStatus(TaskStatus.INPROCESS);
            task.setUser(optionalUser.get());
            return taskRepository.save(task).getTaskDto();
        }
        return null;
    }

}
