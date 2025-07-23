package com.learn.task.controller.employee;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.learn.task.dto.CommentDto;
import com.learn.task.dto.TaskDto;
import com.learn.task.services.employee.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getTasksByUserId() {
        return ResponseEntity.ok(employeeService.getTasksByUserId());
    }

    @GetMapping("task/{id}/{status}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long id,
            @PathVariable("status") String status) {
        TaskDto updateTaskDto = employeeService.updateTask(id, status);
        if (updateTaskDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updateTaskDto);
    }

    @PostMapping("/task/comment/{taskId}")
    public ResponseEntity<CommentDto> createComment(@PathVariable("taskId") Long taskId,
            @RequestParam("content") String content) {
        CommentDto createdComment = employeeService.createComment(taskId, content);
        if (createdComment == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @GetMapping("/comments/{taskId}")
    public ResponseEntity<List<CommentDto>> getCommentsByTaskId(
            @PathVariable("taskId") Long taskId) {
        return ResponseEntity.ok(employeeService.getCommentByTaskId(taskId));
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(employeeService.getById(id));
    }
}
