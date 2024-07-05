package com.ikiseh.My_Task_Management_System.payLoad.request.task;

import com.ikiseh.My_Task_Management_System.model.enumms.PriorityLevel;
import com.ikiseh.My_Task_Management_System.model.enumms.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateTaskRequest {
    private String taskTitle;
    private String taskDescription;
    private LocalDateTime taskStartDate;
    private LocalDateTime taskDeadline;
    private PriorityLevel priorityLevel;
    private TaskStatus taskStatus;
}