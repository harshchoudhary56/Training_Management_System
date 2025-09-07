package com.ec_infosolutions.training_management_system.response;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private LocationResponse location;
    private RoleResponse role;
    private String expertise;
    private Date enrollmentDate;
}
