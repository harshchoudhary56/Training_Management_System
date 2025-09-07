package com.ec_infosolutions.training_management_system.mapper;

import com.ec_infosolutions.training_management_system.entities.Location;
import com.ec_infosolutions.training_management_system.entities.Permission;
import com.ec_infosolutions.training_management_system.entities.Role;
import com.ec_infosolutions.training_management_system.entities.User;
import com.ec_infosolutions.training_management_system.request.UserRequest;
import com.ec_infosolutions.training_management_system.response.LocationResponse;
import com.ec_infosolutions.training_management_system.response.PermissionResponse;
import com.ec_infosolutions.training_management_system.response.RoleResponse;
import com.ec_infosolutions.training_management_system.response.UserResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
        @Mapping(target = "location", source = "location"),
        @Mapping(target = "role", source = "role"),
        @Mapping(target = "enrollmentDate", source = "enrollmentDate")
    })
    UserResponse userToUserResponse(User user);

    @Mappings({
        @Mapping(target = "city", source = "name"),
        @Mapping(target = "state", expression = "java(location.getParent().getName())"),
        @Mapping(target = "country", expression = "java(location.getParent().getParent().getName())")
    })
    LocationResponse locationToLocationResponse(Location location);

    @Mapping(target = "role", source = "role")
    RoleResponse roleToRoleResponse(Role role);

    PermissionResponse permissionToPermissionResponse(Permission permission);

    @Mappings({
        @Mapping(target = "enrollmentDate", expression = "java(java.time.LocalDate.now())"),
        @Mapping(target = "status", expression = "java(com.ec_infosolutions.training_management_system.constants.UserStatus.ACTIVE)"),
        @Mapping(target = "password", expression = "java(passwordEncoder.encode(request.getPassword()))"),
    })
    User userRequestToUser(UserRequest request, PasswordEncoder passwordEncoder);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromRequest(UserRequest request, @MappingTarget User user);
}
