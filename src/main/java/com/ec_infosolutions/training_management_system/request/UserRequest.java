package com.ec_infosolutions.training_management_system.request;

import com.ec_infosolutions.training_management_system.constants.Role;
import lombok.Data;

@Data
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Role role;
    private Integer locationId;
    private String expertise;
}
