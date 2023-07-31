/**
 * 
 */
package com.taodigitalusa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;import org.springframework.web.bind.annotation.PathVariable;

import com.taodigitalusa.todolist.domain.Task;
import com.taodigitalusa.todolist.domain.User;
import com.taodigitalusa.todolist.service.TaskService;
import com.taodigitalusa.todolist.service.UserService;





/**
 * 
 */
@RestController
@RequestMapping("/taskmgmt")
public class TaskController {
	

	 @Autowired
	 private TaskService taskService;
	 @Autowired
	 private UserService userService;
	//Create Task: 1.	Endpoint: POST /api/tasks
	
	@PostMapping("/api/tasks")
    public String createTask(@RequestBody Task task) { 
		 taskService.createTask(task);
       return "successfully task created";
    }
	
	//Endpoint: PUT /api/tasks/{taskId}
	
	@PutMapping("/api/tasks/{taskId}")
    public String updateTask(@PathVariable("taskId") Long taskId,@RequestBody Task task) {    
		taskService.updateTask(taskId, task);
       return "successfully updated Task created";
    }
	
	/*Delete Task: Endpoint: DELETE /api/tasks/{taskId}
       Description: Delete a task.*/
	
	@DeleteMapping("/api/tasks/{taskId}")
    public String deleteTask(@PathVariable("taskId") Long taskId) {
		taskService.deleteTask(taskId);
       return "Deleted taskId"+taskId;
    }
	
	/*Get All Tasks: Endpoint: GET /api/tasks Description: Get a list of all tasks.*/
	
	@GetMapping("/api/tasks")
    public List<Task> getAllTasks() {       
       return taskService.findAllByOrderByEndDateAsc();
    }
	
	/*Endpoint: POST /api/tasks/{taskId}/assign
 Request Body: User ID Description: Assign a task to a specific user.*/	
	

	@PostMapping("/api/tasks/{email}/{taskId}/assign")
    public String assignTask(@PathVariable("taskId") Long taskId,@PathVariable("email") String email) { 
		Task selectedTask=taskService.getTaskById(taskId);
        taskService.assignUserToTask(selectedTask, userService.getUserByEmail(email));
       return "Successfully Assign a task to a specific user";
    }
	/*Get Users Assigned Tasks:
    Endpoint: GET /api/users/{userId}/tasks
     Description: Get a list of tasks assigned to a specific user.*/
	
	@GetMapping("/api/users/{useremaildID}/tasks")
    public List<Task> getUserAssignedTasks(@PathVariable("useremaildID") String useremaildID) {       
       return  taskService.findTasksByUser(userService.getUserByEmail(useremaildID));
    }
	
	/*  
	 * Set Task Progress:
   Endpoint: PUT /api/tasks/{taskId}/progress
   Request Body: Progress percentage (0-100)
   Description: Set the progress percentage of a task.
	 */
	
	@PutMapping("/api/tasks/{taskId}/progress")
    public String setTaskProgress(@PathVariable("taskId") Long taskId,@RequestBody Task task) {  
		Task selectedTask=taskService.getTaskById(taskId);
		taskService.updateTask(taskId, selectedTask);
       return "Set the progress percentage of a task";
    }
	
	
	@GetMapping("/api/tasks/statistics")
    public String getTasksByDateRange() {       
       return "Get statistics on the total number of tasks, the number of completed tasks, and the\r\n"
       		+ "percentage of completed tasks";
    }
	
	
	@GetMapping("/users")
    public List<User> listUsers() {
        return userService.findAll();
    }
	
	
}
