package com.learn.task.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.task.dto.TaskDto;
import com.learn.task.services.admin.AdminService;
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

    @PostMapping("/task")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto createdTask = adminService.createTask(taskDto);
        if (createdTask == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping("/tasks")
    public ResponseEntity<?> getAllTask() {
        return ResponseEntity.ok(adminService.getAllTask());
    }
}
