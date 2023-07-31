package com.taodigitalusa.todolist.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taodigitalusa.todolist.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
