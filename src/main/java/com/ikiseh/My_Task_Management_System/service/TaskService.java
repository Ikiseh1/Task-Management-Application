package com.ikiseh.My_Task_Management_System.service;

import com.ikiseh.My_Task_Management_System.model.enumms.TaskStatus;
import com.ikiseh.My_Task_Management_System.payLoad.request.task.CreateTaskRequest;
import com.ikiseh.My_Task_Management_System.payLoad.request.task.UpdateTaskRequest;
import com.ikiseh.My_Task_Management_System.payLoad.request.task.UpdateTaskStatusRequest;
import com.ikiseh.My_Task_Management_System.payLoad.response.task.TaskCreateResponse;
import com.ikiseh.My_Task_Management_System.payLoad.response.task.TaskDeleteResponse;
import com.ikiseh.My_Task_Management_System.payLoad.response.task.TaskDetailResponse;
import com.ikiseh.My_Task_Management_System.payLoad.response.task.TaskUpdateResponse;

import java.util.List;

public interface TaskService {

    TaskCreateResponse createTask(CreateTaskRequest createTaskRequest);

    TaskUpdateResponse updateTaskStatus(Long id, UpdateTaskStatusRequest updateTaskStatusRequest);

    TaskDetailResponse getTaskById(Long id);

    TaskDetailResponse getTaskByTitle(String title);

    List<TaskDetailResponse> getTasksByUserId(Long userId);

    TaskUpdateResponse updateTask(Long id, UpdateTaskRequest updateTaskRequest);

    TaskDeleteResponse deleteTask(Long id);

    List<TaskDetailResponse> getTasksByStatus(TaskStatus taskStatus);


}
