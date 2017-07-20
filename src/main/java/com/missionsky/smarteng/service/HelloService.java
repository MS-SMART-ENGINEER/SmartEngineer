package com.missionsky.smarteng.service;

import com.missionsky.smarteng.mapper.UserMapper;
import com.missionsky.smarteng.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    private UserMapper userMapper;

    public String getGreeting() {
        return "Greetings from Spring Boot service!";
    }

    public String getUserName(String userId) {
        User user = userMapper.getUserById(userId);
        if (user != null) {
            return user.getName();
        }
        else {
            return "Unknown";
        }
    }

    public User getUser(String userId) {
        return userMapper.getUserById(userId);
    }

    public List<User> getUsers(){return userMapper.getUsers();}
}
