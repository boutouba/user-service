package com.userservice.dto;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String username;
    private String fullname;

    public UserResponse() {
    }

    public UserResponse(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }

}
