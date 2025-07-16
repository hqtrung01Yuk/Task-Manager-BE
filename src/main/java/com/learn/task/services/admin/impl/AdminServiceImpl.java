package com.learn.task.services.admin.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

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
        List<Task> tasks = taskRepository.findAll();

        List<TaskDto> taskDtos =
                tasks.stream().sorted(Comparator.comparing(Task::getDueDate).reversed())
                        .map(Task::getTaskDto).collect(Collectors.toList());

        logger.info("Total tasks fetched: {}", tasks.size());
        logger.info("Total tasks after sorting and mapping: {}", taskDtos.size());

        return taskDtos;
    }

    @Override
    public void deleteTask(Long id) {
        logger.info("Attempting to delete task with id: {}", id);

        if (!taskRepository.existsById(id)) {
            logger.warn("Task with id {} does not exist. Skipping deletion.", id);
            throw new EntityNotFoundException("Task not found with id: " + id);
        }

        taskRepository.deleteById(id);
        logger.info("Successfully deleted task with id: {}", id);
    }

    @Override
    public TaskDto getById(Long id) {
        logger.info("Getting task by id: {}", id);
        return taskRepository.findById(id).map(task -> {
            logger.info("Task found with id: {}", id);
            return task.getTaskDto();
        }).orElseThrow(() -> {
            logger.warn("Task not found with id: {}", id);
            return new EntityNotFoundException("Task not found with id: " + id);
        });
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        logger.info("Updating task with id: {}", id);

        return taskRepository.findById(id).map(task -> {
            logger.info("Task found. Updating fields...");
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setDueDate(taskDto.getDueDate());
            task.setPriority(taskDto.getPriority());
            if (taskDto.getTaskStatus() != null) {
                task.setTaskStatus(mapstringToTaskStatus(taskDto.getTaskStatus().name()));
            } else {
                logger.warn("TaskStatus is null in DTO. Setting default to CANCELLED.");
                task.setTaskStatus(TaskStatus.CANCELLED); // hoặc giữ nguyên status cũ nếu muốn
            }

            if (taskDto.getEmployeeId() != null) {
                logger.info("Found employee id: " + taskDto.getEmployeeId());
                userRepository.findById(taskDto.getEmployeeId()).ifPresentOrElse(task::setUser,
                        () -> logger.warn(
                                "Employee with id {} not found. Skipping employee assignment.",
                                taskDto.getEmployeeId()));
            } else {
                logger.warn("EmployeeId is null in taskDto.");
            }

            // save to db
            Task updatedTask = taskRepository.save(task);
            logger.info("Task updated successfully with id: {}", updatedTask.getId());
            return updatedTask;
        }).map(Task::getTaskDto).orElseThrow(() -> {
            logger.warn("Task not found with id: {}", id);
            return new EntityNotFoundException("Task not found with id: " + id);
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

    @Override
    public List<TaskDto> searchTaskByTitle(String title) {
        try {
            logger.info("Searching tasks with title containing: {}", title);

            List<TaskDto> result = taskRepository.findAllByTitleContaining(title).stream()
                    .peek(task -> logger.trace("Processing task: {} with due date: {}",
                            task.getId(), task.getDueDate()))
                    .sorted(Comparator.comparing(Task::getDueDate,
                            Comparator.nullsLast(Comparator.reverseOrder())))
                    .map(Task::getTaskDto).peek(dto -> logger.trace("Mapped to DTO: {}", dto))
                    .collect(Collectors.toList());

            logger.info("Returning {} sorted tasks", result.size());
            return result;
        } catch (Exception e) {
            logger.error("Error occurred while searching tasks by title: " + title, e);
            throw e;
        }
    }
}
