package com.ikiseh.My_Task_Management_System.payLoad.request.task;

import com.ikiseh.My_Task_Management_System.model.enumms.TaskStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTaskStatusRequest {
    private Long id;
    private TaskStatus taskStatus;
}
