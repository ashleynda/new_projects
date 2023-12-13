package com.tatafo.dtos.request;

import lombok.Data;

@Data
public class RegisterUserRequest {

    private String userName;
    private String password;
}
