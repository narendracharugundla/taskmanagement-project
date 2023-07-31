package com.taodigitalusa.todolist.service;


import java.util.List;

import com.taodigitalusa.todolist.domain.User;

public interface UserService {
    void createUser(User user);
    void createAdmin(User user);

    List<User> findAll();
    User getUserByEmail(String email);
    boolean isUserPresent(String email);
}
