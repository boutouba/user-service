package com.userservice.controller;

import com.userservice.dto.UserRequest;
import com.userservice.entity.User;
import com.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    public UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path="/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getPosts() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(path="/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<User>> getPost(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/user/add", method = RequestMethod.POST)
    public ResponseEntity<User> createPost(@RequestBody UserRequest userRequest) throws Exception {
        User post = userService.createUser(userRequest);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @RequestMapping(path = "/user/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updatePost(@RequestBody UserRequest userRequest, @PathVariable Long id) throws Exception {
        User post = userService.updateUser(userRequest, id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @RequestMapping(path = "/user/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> updatePost(@PathVariable Long id) throws Exception {
        User post = userService.deleteUser(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
