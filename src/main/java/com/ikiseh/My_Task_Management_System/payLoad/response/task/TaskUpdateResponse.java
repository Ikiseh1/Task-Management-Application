package com.ikiseh.My_Task_Management_System.payLoad.response.task;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TaskUpdateResponse {
    private String responseCode;
    private String responseMessage;
}
