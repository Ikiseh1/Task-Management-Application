package com.ikiseh.My_Task_Management_System.controller;


import com.ikiseh.My_Task_Management_System.model.enumms.TaskStatus;
import com.ikiseh.My_Task_Management_System.payLoad.request.task.CreateTaskRequest;
import com.ikiseh.My_Task_Management_System.payLoad.request.task.UpdateTaskRequest;
import com.ikiseh.My_Task_Management_System.payLoad.request.task.UpdateTaskStatusRequest;
import com.ikiseh.My_Task_Management_System.payLoad.response.task.TaskCreateResponse;
import com.ikiseh.My_Task_Management_System.payLoad.response.task.TaskDeleteResponse;
import com.ikiseh.My_Task_Management_System.payLoad.response.task.TaskDetailResponse;
import com.ikiseh.My_Task_Management_System.payLoad.response.task.TaskUpdateResponse;
import com.ikiseh.My_Task_Management_System.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @PostMapping("/create-task")
    public ResponseEntity<TaskCreateResponse> createTask(@RequestBody CreateTaskRequest createTaskRequest){
        TaskCreateResponse taskCreateResponse = taskService.createTask(createTaskRequest);
        return ResponseEntity.ok(taskCreateResponse);
    }

    @PutMapping("/updateStatus/{id}")
    public TaskUpdateResponse updateTaskStatus(@PathVariable Long id, @RequestBody UpdateTaskStatusRequest updateTaskStatusRequest) {
        return taskService.updateTaskStatus(id, updateTaskStatusRequest);
    }

    @GetMapping("/{id}")
    public TaskDetailResponse getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/title/{title}")
    public TaskDetailResponse getTaskByTitle(@PathVariable String title) {
        return taskService.getTaskByTitle(title);
    }

    @GetMapping("/user/{userId}")
    public List<TaskDetailResponse> getTasksByUserId(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    @PutMapping("/update/{id}")
    public TaskUpdateResponse updateTask(@PathVariable Long id, @RequestBody UpdateTaskRequest updateTaskRequest) {
        return taskService.updateTask(id, updateTaskRequest);
    }

    @DeleteMapping("/delete/{id}")
    public TaskDeleteResponse deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

    @GetMapping("/status/{status}")
    public List<TaskDetailResponse> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }
}
