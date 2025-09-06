package com.ec_infosolutions.training_management_system.service;

import com.ec_infosolutions.training_management_system.constants.UserStatus;
import com.ec_infosolutions.training_management_system.entities.Location;
import com.ec_infosolutions.training_management_system.entities.User;
import com.ec_infosolutions.training_management_system.mapper.UserMapper;
import com.ec_infosolutions.training_management_system.repository.LocationRepository;
import com.ec_infosolutions.training_management_system.repository.UserRepository;
import com.ec_infosolutions.training_management_system.request.UserRequest;
import com.ec_infosolutions.training_management_system.response.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LocationRepository locationRepository;

    public List<UserResponse> findAll() {
        return userRepository.findAllActiveUsers().stream()
                .map(userMapper::userToUserResponse)
                .toList();
    }

    public UserResponse findById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return userMapper.userToUserResponse(user);
    }

    public UserResponse register(UserRequest request) {
        User user = userMapper.userRequestToUser(request, passwordEncoder);

        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new EntityNotFoundException("Location not found with id: " + request.getLocationId()));

        user.setLocation(location);
        return userMapper.userToUserResponse(userRepository.save(user));
    }

    public UserResponse update(Integer id, UserRequest request) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        userMapper.updateUserFromRequest(request, existingUser);

        if (request.getLocationId() != null) {
            Location location = locationRepository.findById(request.getLocationId())
                    .orElseThrow(() -> new EntityNotFoundException("Location not found with id: " + request.getLocationId()));
            existingUser.setLocation(location);
        }
        return userMapper.userToUserResponse(userRepository.save(existingUser));
    }

    public UserResponse delete(Integer id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        existingUser.setStatus(UserStatus.INACTIVE);
        return userMapper.userToUserResponse(userRepository.save(existingUser));
    }
}
