package com.userservice.dto;

import lombok.Data;

@Data
public class UserNPRequest {

    private String username;
    private String fullname;

    public UserNPRequest() {
    }

    public UserNPRequest(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }


}
