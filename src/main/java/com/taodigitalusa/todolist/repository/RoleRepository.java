package com.taodigitalusa.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taodigitalusa.todolist.domain.Role;


public interface RoleRepository extends JpaRepository<Role, String> {
    Object findByName(String role_user);
}
