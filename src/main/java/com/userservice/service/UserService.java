package com.userservice.service;

import com.userservice.dto.UserNPRequest;
import com.userservice.dto.UserRequest;
import com.userservice.dto.UserResponse;
import com.userservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<UserResponse> getUsers();

    public Optional<User> getUser(Long id);

    public User createUser(UserRequest post) throws Exception;

    public User updateUser(UserNPRequest post, Long id) throws Exception;


    public User deleteUser(Long id) throws Exception;

}
