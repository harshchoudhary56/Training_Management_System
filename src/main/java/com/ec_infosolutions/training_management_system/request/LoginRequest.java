package com.ec_infosolutions.training_management_system.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}