package com.learn.task.controller.admin;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.task.dto.TaskDto;
import com.learn.task.services.admin.AdminService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(adminService.getUsers());
    }

    @PostMapping("/create-task")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto createdTask = adminService.createTask(taskDto);
        if (createdTask == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PostMapping("/create-tasks")
    public ResponseEntity<?> createTasks(@RequestBody List<TaskDto> taskList) {
        List<TaskDto> createdTasks =
                taskList.stream().map(adminService::createTask).collect(Collectors.toList());

        return ResponseEntity.ok(createdTasks);
    }

    @GetMapping("/tasks")
    public ResponseEntity<?> getAllTask() {
        return ResponseEntity.ok(adminService.getAllTask());
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
        try {
            adminService.deleteTask(id);
            return ResponseEntity.ok(Map.of("message", "Task deleted successfully"));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Task not found"));
        }
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(adminService.getById(id));
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") Long id, @RequestBody TaskDto taskDto) {
        TaskDto updatedTask = adminService.updateTask(id, taskDto);
        if (updatedTask == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTask);
    }
}
