package com.ikiseh.My_Task_Management_System.payLoad.response.task;

import com.ikiseh.My_Task_Management_System.model.enumms.PriorityLevel;
import com.ikiseh.My_Task_Management_System.model.enumms.TaskStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskDetailResponse {
    private Long id;
    private String taskTitle;
    private String taskDescription;
    private String email;
    private LocalDateTime taskStartDate;
    private LocalDateTime taskDeadline;
    private PriorityLevel priorityLevel;
    private TaskStatus taskStatus;

}
