package com.example.bloggheaven.services;

import com.example.bloggheaven.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserServiceInterface {
    List<User> getAllusers();
    User getUserById(int id);
    User addUser(User user);
    void deleteUserById(int id);
    User updateUser(int id, User user);
}
