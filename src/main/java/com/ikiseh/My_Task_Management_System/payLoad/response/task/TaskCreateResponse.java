package com.ikiseh.My_Task_Management_System.payLoad.response.task;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class TaskCreateResponse {

    private String responseCode;

    private String responseMessage;

    private TaskCreateInfo taskCreateInfo;

    public TaskCreateResponse(String responseCode, String responseMessage, TaskCreateInfo taskCreateInfo) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.taskCreateInfo = taskCreateInfo;
    }
}
