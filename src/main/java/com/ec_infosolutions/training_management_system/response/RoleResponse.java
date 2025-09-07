package com.ec_infosolutions.training_management_system.response;

import lombok.Data;

import java.util.List;

@Data
public class RoleResponse {

    private String role;
    private List<PermissionResponse> permissions;
}
