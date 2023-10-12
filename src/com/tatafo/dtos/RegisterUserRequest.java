package com.tatafo.dtos;

import lombok.Data;

@Data
public class RegisterUserRequest {

    private String userName;
    private String password;
}
