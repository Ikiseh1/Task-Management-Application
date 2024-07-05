package com.ikiseh.My_Task_Management_System.payLoad.response.task;


import com.ikiseh.My_Task_Management_System.model.enumms.PriorityLevel;
import com.ikiseh.My_Task_Management_System.model.enumms.TaskStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskCreateInfo {

    private String userId;
    private String taskTitle;
    private String taskDescription;
    private String email;
    private LocalDateTime taskStartDate;
    private LocalDateTime taskDeadline;
    private PriorityLevel priorityLevel;
    private TaskStatus taskStatus;


}
