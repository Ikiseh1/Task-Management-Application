package com.ikiseh.My_Task_Management_System.service.impl;

import com.ikiseh.My_Task_Management_System.model.entity.Task;
import com.ikiseh.My_Task_Management_System.model.entity.User;
import com.ikiseh.My_Task_Management_System.model.enumms.TaskStatus;
import com.ikiseh.My_Task_Management_System.payLoad.request.task.CreateTaskRequest;
import com.ikiseh.My_Task_Management_System.payLoad.request.task.UpdateTaskRequest;
import com.ikiseh.My_Task_Management_System.payLoad.request.task.UpdateTaskStatusRequest;
import com.ikiseh.My_Task_Management_System.payLoad.response.task.*;
import com.ikiseh.My_Task_Management_System.repository.TaskRepository;
import com.ikiseh.My_Task_Management_System.repository.UserRepository;
import com.ikiseh.My_Task_Management_System.service.TaskService;
import com.ikiseh.My_Task_Management_System.utils.RegistrationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    LocalDateTime now = LocalDateTime.now();


    @Override
    public TaskCreateResponse createTask(CreateTaskRequest createTaskRequest) {


        Optional<User> userOptional = userRepository.findByEmail(createTaskRequest.getEmail());
        if (userOptional.isEmpty()) {
            return TaskCreateResponse.builder()
                    .responseCode(RegistrationUtils.USER_DOES_NOT_EXIST_CODE)
                    .responseMessage(RegistrationUtils.USER_DOES_NOT_EXIST_MESSAGE)
                    .build();
        }
        User user = userOptional.get();

        Task task = Task.builder()
                .taskTitle(createTaskRequest.getTaskTitle())
                .taskDescription(createTaskRequest.getTaskDescription())
                .email(createTaskRequest.getEmail())
                .taskStartDate(now)
                .taskDeadline(now)
                .user(user)
                .priorityLevel(createTaskRequest.getPriorityLevel())
                .taskStatus(TaskStatus.PENDING)
                .build();

       Task taskCreated = taskRepository.save(task);

        TaskCreateInfo taskCreateInfo = TaskCreateInfo.builder()
                .taskTitle(taskCreated.getTaskTitle())
                .taskDescription(taskCreated.getTaskDescription())
                .userId(String.valueOf(taskCreated.getUser()))
                .email(taskCreated.getEmail())
                .taskStartDate(taskCreated.getTaskStartDate())
                .taskDeadline(taskCreated.getTaskDeadline())
                .priorityLevel(taskCreated.getPriorityLevel())
                .taskStatus(taskCreated.getTaskStatus())
                .build();

        return TaskCreateResponse.builder()
                .responseCode("TASK_CREATED_SUCCESSFULLY")
                .responseMessage("Task has been created successfully.")
                .taskCreateInfo(taskCreateInfo)
                .build();
    }

    @Override
    public TaskUpdateResponse updateTaskStatus(Long id, UpdateTaskStatusRequest updateTaskStatusRequest) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            return TaskUpdateResponse.builder()
                    .responseCode("TASK_NOT_FOUND")
                    .responseMessage("Task not found with the provided ID.")
                    .build();
        }
        Task task = taskOptional.get();
        task.setTaskStatus(updateTaskStatusRequest.getTaskStatus());
        taskRepository.save(task);

        return TaskUpdateResponse.builder()
                .responseCode("TASK_STATUS_UPDATED_SUCCESSFULLY")
                .responseMessage("Task status has been updated successfully.")
                .build();

    }

    @Override
    public TaskDetailResponse getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            return null; //exception will be here sprint creep
        }
        Task task = taskOptional.get();

        return TaskDetailResponse.builder()
                .id(task.getId())
                .taskTitle(task.getTaskTitle())
                .taskDescription(task.getTaskDescription())
                .email(task.getEmail())
                .taskStartDate(task.getTaskStartDate())
                .taskDeadline(task.getTaskDeadline())
                .priorityLevel(task.getPriorityLevel())
                .taskStatus(task.getTaskStatus())
                .build();
    }


    @Override
    public TaskDetailResponse getTaskByTitle(String taskTitle) {
        Optional<Task> taskOptional = taskRepository.findByTaskTitle(taskTitle);
        if (taskOptional.isEmpty()) {
            return null; // Or throw an exception if preferred
        }
        Task task = taskOptional.get();

        return TaskDetailResponse.builder()
                .id(task.getId())
                .taskTitle(task.getTaskTitle())
                .taskDescription(task.getTaskDescription())
                .email(task.getEmail())
                .taskStartDate(task.getTaskStartDate())
                .taskDeadline(task.getTaskDeadline())
                .priorityLevel(task.getPriorityLevel())
                .taskStatus(task.getTaskStatus())
                .build();
    }

    @Override
    public List<TaskDetailResponse> getTasksByUserId(Long userId) {
        List<Task> tasks = taskRepository.findByUserId(userId);
        return tasks.stream().map(task -> TaskDetailResponse.builder()
                .id(task.getId())
                .taskTitle(task.getTaskTitle())
                .taskDescription(task.getTaskDescription())
                .email(task.getEmail())
                .taskStartDate(task.getTaskStartDate())
                .taskDeadline(task.getTaskDeadline())
                .priorityLevel(task.getPriorityLevel())
                .taskStatus(task.getTaskStatus())
                .build()).collect(Collectors.toList());
    }

    @Override
    public TaskUpdateResponse updateTask(Long id, UpdateTaskRequest updateTaskRequest) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            return TaskUpdateResponse.builder()
                    .responseCode("TASK_NOT_FOUND")
                    .responseMessage("Task not found with the provided ID.")
                    .build();
        }
        Task task = taskOptional.get();

        if (updateTaskRequest.getTaskTitle() != null) {
            task.setTaskTitle(updateTaskRequest.getTaskTitle());
        }
        if (updateTaskRequest.getTaskDescription() != null) {
            task.setTaskDescription(updateTaskRequest.getTaskDescription());
        }
        if (updateTaskRequest.getTaskStartDate() != null) {
            task.setTaskStartDate(updateTaskRequest.getTaskStartDate());
        }
        if (updateTaskRequest.getTaskDeadline() != null) {
            task.setTaskDeadline(updateTaskRequest.getTaskDeadline());
        }
        if (updateTaskRequest.getPriorityLevel() != null) {
            task.setPriorityLevel(updateTaskRequest.getPriorityLevel());
        }
        if (updateTaskRequest.getTaskStatus() != null) {
            task.setTaskStatus(updateTaskRequest.getTaskStatus());
        }

        taskRepository.save(task);

        return TaskUpdateResponse.builder()
                .responseCode("TASK_UPDATED_SUCCESSFULLY")
                .responseMessage("Task has been updated successfully.")
                .build();
    }

    @Override
    public TaskDeleteResponse deleteTask(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            return TaskDeleteResponse.builder()
                    .responseCode("TASK_NOT_FOUND")
                    .responseMessage("Task not found with the provided ID.")
                    .build();
        }

        taskRepository.deleteById(id);

        return TaskDeleteResponse.builder()
                .responseCode("TASK_DELETED_SUCCESSFULLY")
                .responseMessage("Task has been deleted successfully.")
                .build();
    }

    @Override
    public List<TaskDetailResponse> getTasksByStatus(TaskStatus taskStatus) {
        List<Task> tasks = taskRepository.findByTaskStatus(taskStatus);
        return tasks.stream().map(task -> TaskDetailResponse.builder()
                .id(task.getId())
                .taskTitle(task.getTaskTitle())
                .taskDescription(task.getTaskDescription())
                .email(task.getEmail())
                .taskStartDate(task.getTaskStartDate())
                .taskDeadline(task.getTaskDeadline())
                .priorityLevel(task.getPriorityLevel())
                .taskStatus(task.getTaskStatus())
                .build()).collect(Collectors.toList());
    }
}