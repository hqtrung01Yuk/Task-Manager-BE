package com.learn.task.controller.employee;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.task.dto.TaskDto;
import com.learn.task.services.employee.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getTasksByUserId() {
        return ResponseEntity.ok(employeeService.getTasksByUserId());
    }
}
