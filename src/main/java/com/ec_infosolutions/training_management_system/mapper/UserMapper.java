package com.ec_infosolutions.training_management_system.mapper;

import com.ec_infosolutions.training_management_system.entities.User;
import com.ec_infosolutions.training_management_system.request.UserRequest;
import com.ec_infosolutions.training_management_system.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserResponse userToUserResponse(User user);

    @Mappings({
        @Mapping(target = "enrollmentDate", expression = "java(new Date())"),
        @Mapping(target = "status", expression = "java(UserStatus.ACTIVE)"),
        @Mapping(target = "password", expression = "java(passwordEncoder.encode(request.getPassword()))"),
    })
    User userRequestToUser(UserRequest request, PasswordEncoder passwordEncoder);


    @Mappings({
        @Mapping(target = "firstName", ignore = true),
        @Mapping(target = "lastName", ignore = true),
        @Mapping(target = "email", ignore = true),
        @Mapping(target = "password", ignore = true),
        @Mapping(target = "expertise",ignore = true)
    })
    void updateUserFromRequest(UserRequest request, @MappingTarget User user);
}
