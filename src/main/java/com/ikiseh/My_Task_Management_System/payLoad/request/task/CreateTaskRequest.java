package com.ikiseh.My_Task_Management_System.payLoad.request.task;

import com.ikiseh.My_Task_Management_System.model.enumms.PriorityLevel;
import com.ikiseh.My_Task_Management_System.model.enumms.TaskStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTaskRequest {
    //title, description, deadline, priority level

    private String taskTitle;
    private String taskDescription;
    private String email;
    private String taskStartDate;
    private String taskDeadline;
    private PriorityLevel priorityLevel;
    private TaskStatus taskStatus;

}
