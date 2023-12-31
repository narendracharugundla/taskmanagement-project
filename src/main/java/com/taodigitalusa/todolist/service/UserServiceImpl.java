package com.taodigitalusa.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.taodigitalusa.todolist.domain.Role;
import com.taodigitalusa.todolist.domain.User;
import com.taodigitalusa.todolist.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role roleUser = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(roleUser);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public void createAdmin(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role roleUser = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(roleUser);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findById(email).orElse(null);
    }

    @Override
    public boolean isUserPresent(String email) {
        if (userRepository.findById(email).isPresent()) {
            return true;
        }
        return false;
    }

	
}
