package com.tatafo.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String userName;
    private String password;
}
