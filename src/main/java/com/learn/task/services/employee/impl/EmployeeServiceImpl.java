package com.learn.task.services.employee.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.learn.task.dto.TaskDto;
import com.learn.task.entities.Task;
import com.learn.task.entities.User;
import com.learn.task.enums.TaskStatus;
import com.learn.task.repositories.TaskRepository;
import com.learn.task.services.employee.EmployeeService;
import com.learn.task.services.jwt.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final TaskRepository taskRepository;
    private final JwtUtil jwtUtil;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public List<TaskDto> getTasksByUserId() {
        logger.debug("Attempting to get logged in user for task listing");

        User user = jwtUtil.getLoggedInUser();
        if (user != null) {
            logger.debug("Logged-in user ID: {}", user.getId());

            List<Task> taskList = taskRepository.findAllByUserId(user.getId());
            logger.info("Found {} raw tasks for user ID {}", taskList.size(), user.getId());

            List<TaskDto> tasks = taskList.stream()
                    .sorted(Comparator.comparing(Task::getDueDate,
                            Comparator.nullsLast(Comparator.reverseOrder())))
                    .map(Task::getTaskDto).collect(Collectors.toList());

            logger.info("Returning {} TaskDto(s) for user ID {}", tasks.size(), user.getId());
            return tasks;
        }

        logger.warn("No user found in context for getting tasks");
        throw new EntityNotFoundException("User not found or unauthorized");
    }

    @Override
    public TaskDto updateTask(Long id, String status) {
        return taskRepository.findById(id).map(task -> {
            logger.info("Find task by id: {}", task.getId());
            task.setTaskStatus(mapstringToTaskStatus(status));
            return taskRepository.save(task);
        }).map(Task::getTaskDto).orElseThrow(() -> {
            logger.warn("Cant not found task by id: {}", id);
            throw new EntityNotFoundException("Cant not found task by id: {} " + id);
        });
    }

    private TaskStatus mapstringToTaskStatus(String status) {
        return switch (status) {
            case "PENDING" -> TaskStatus.PENDING;
            case "INPROCESS" -> TaskStatus.INPROCESS;
            case "COMPLETED" -> TaskStatus.COMPLETED;
            case "DEFERED" -> TaskStatus.DEFERED;
            case "CANCELLED" -> TaskStatus.CANCELLED;
            default -> TaskStatus.CANCELLED;
        };
    }
}
