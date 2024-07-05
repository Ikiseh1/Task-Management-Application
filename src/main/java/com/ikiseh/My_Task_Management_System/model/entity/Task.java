package com.ikiseh.My_Task_Management_System.model.entity;


import com.ikiseh.My_Task_Management_System.model.enumms.PriorityLevel;
import com.ikiseh.My_Task_Management_System.model.enumms.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "task_title", nullable = false)
private String taskTitle;

@Column(name = "task_description")
private String taskDescription;

@Column(name = "email")
private String email;

@Column(name = "task_start_date")
private LocalDateTime taskStartDate;

@Column(name = "task_deadline")
private LocalDateTime taskDeadline;

@Enumerated(EnumType.STRING)
@Column(name = "priority_level")
private PriorityLevel priorityLevel;

@Enumerated(EnumType.STRING)
@Column(name = "task_status")
private TaskStatus taskStatus;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;
}