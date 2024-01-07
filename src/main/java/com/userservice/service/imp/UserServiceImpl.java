package com.userservice.service.imp;

import com.userservice.dto.UserNPRequest;
import com.userservice.dto.UserRequest;
import com.userservice.dto.UserResponse;
import com.userservice.entity.User;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

     private UserRepository userRepository;

     public UserServiceImpl(UserRepository userRepository) {
         this.userRepository = userRepository;
     }

    public List<UserResponse> getUsers() {
         List<UserResponse> userResponses = new ArrayList<>();
         List<User> users = userRepository.findAll();
        for(User u : users) {
            UserResponse ur = new UserResponse();
            ur.setUsername(u.getUsername());
            ur.setId(u.getId());
            ur.setFullname(u.getFullname());
            userResponses.add(ur);
        }
        return userResponses;
    }

    public Optional<User> getUser(Long id) {
         return userRepository.findById(id);
    }

    public User createUser(UserRequest user) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(user.getPassword());
        User p = new User();
        //Type t = userRepository.findById(user.getType()).orElse(null);
        //if (t == null) {
        //    throw new Exception("Post not found");
        //}
        p.setUsername(user.getUsername());
        p.setFullname(user.getFullname());
        p.setPassword(password);
        userRepository.save(p);
        return p;
    }

    public User updateUser(UserNPRequest user, Long id) throws Exception {
        User p = userRepository.findById(id).orElse(null);
        p.setUsername(user.getUsername());
        p.setFullname(user.getFullname());
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String password = passwordEncoder.encode(user.getPassword());
//        p.setPassword(password);
        userRepository.save(p);
        return p;
    }

    public User deleteUser(Long id) throws Exception {
        User p = userRepository.findById(id).orElse(null);
        if (p == null) {
            throw new Exception("Post not found");
        }
        userRepository.delete(p);
        return p;
    }

}
