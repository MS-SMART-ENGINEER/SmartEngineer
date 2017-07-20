package com.missionsky.smarteng.mapper;

import com.missionsky.smarteng.model.User;

import java.util.List;

public interface UserMapper {
    User getUserById(String userId);
    List<User> getUsers();
}
