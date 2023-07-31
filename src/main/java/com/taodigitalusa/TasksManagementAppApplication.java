package com.taodigitalusa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Create APIs and tables to manage tasks and their statuses with additional functionalities like assigning
tasks to users, setting due dates, and tracking progress. Here are the API requirements and business
logic: (Please use Java 8 or above)*/
@SpringBootApplication
public class TasksManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksManagementAppApplication.class, args);
	}

}

/*Design the necessary database tables to store the Task and User entities, along with any additional
tables required to support the functionalities mentioned above. You can choose your preferred
database and define appropriate data types and lengths for the properties.
Please create the Spring Boot application with the above APIs and database tables according to the
provided requirements. Handle error responses and validations appropriately, and implement the
necessary business logic for task management and assignment.*/