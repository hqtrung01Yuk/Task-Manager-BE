package com.learn.task.dto;

import java.util.Date;
import com.learn.task.enums.TaskStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Date dueDate;
    private String priority;
    private TaskStatus taskStatus;
    private Long employeeId;
    private String employeeName;

    // Constructor phải khớp CHÍNH XÁC với query JPQL
    public TaskDto(Long id, String title, String description, Date dueDate, String priority,
            TaskStatus taskStatus, Long employeeId, String employeeName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.taskStatus = taskStatus;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }
}
