package com.taodigitalusa.todolist.service;

import java.util.List;
import com.taodigitalusa.todolist.domain.Task;
import com.taodigitalusa.todolist.domain.User;


public interface TaskService {

    List<Task> findAll();
    void createTask(Task task);
    void updateTask(Long id, Task updatedTask);
    void deleteTask(Long id);
    Task getTaskById(Long id);
    void setTaskCompleted(Long id);
    void setTaskNotCompleted(Long id);
    List<Task> findTasksByUser(User user);
    void assignUserToTask(Task task, User user);
    List<Task> findAllByOrderByEndDateAsc();
}
