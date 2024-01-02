package com.userservice.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String fullname;
    private String password;

    public UserRequest() {
    }

    public UserRequest(String username, String fullname, String password) {
        this.password = password;
        this.username = username;
        this.fullname = fullname;
    }


}
