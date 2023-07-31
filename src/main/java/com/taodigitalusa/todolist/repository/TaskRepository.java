package com.taodigitalusa.todolist.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taodigitalusa.todolist.domain.Task;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    //List<Task> findByUser(User user);
    List<Task> findAllByOrderByEndDateAsc();
    //List<Task> findTasksByUserOrderByEndDateAsc(User user);
}