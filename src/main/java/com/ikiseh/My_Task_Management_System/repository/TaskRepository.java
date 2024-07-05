package com.ikiseh.My_Task_Management_System.repository;

import com.ikiseh.My_Task_Management_System.model.entity.Task;
import com.ikiseh.My_Task_Management_System.model.enumms.TaskStatus;
import com.ikiseh.My_Task_Management_System.payLoad.response.task.TaskDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {


    Optional<Task> findByTaskTitle(String taskTitle);

    List<Task> findByUserId(Long userId);

    List<Task> findByTaskStatus(TaskStatus taskStatus);



}
