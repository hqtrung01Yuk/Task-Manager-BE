package com.learn.task.dto;

import java.util.Date;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String content;
    private Date createAt;
    private Long createdById;
    private String createdByName;
    private Long userId;
    private String userName;
    private Long taskId;
    private String taskTitle;
}
