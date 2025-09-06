package com.ec_infosolutions.training_management_system.response;

import com.ec_infosolutions.training_management_system.constants.Role;
import lombok.Data;

import java.util.Date;

@Data
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private LocationResponse location;
    private String expertise;
    private Date enrollmentDate;
}
