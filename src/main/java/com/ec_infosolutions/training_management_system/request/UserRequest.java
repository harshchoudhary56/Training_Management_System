package com.ec_infosolutions.training_management_system.request;

import lombok.Data;

@Data
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer locationId;
    private Integer roleId;
    private String expertise;
}
