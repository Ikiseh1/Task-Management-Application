package com.ikiseh.My_Task_Management_System.payLoad.response.task;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDeleteResponse {
    private String responseCode;
    private String responseMessage;
}