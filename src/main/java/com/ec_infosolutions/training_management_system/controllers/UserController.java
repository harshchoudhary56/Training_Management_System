package com.ec_infosolutions.training_management_system.controllers;

import com.ec_infosolutions.training_management_system.request.UserRequest;
import com.ec_infosolutions.training_management_system.response.UserResponse;
import com.ec_infosolutions.training_management_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping({"", "/{id}"})
    public ResponseEntity<List<UserResponse>> findUserByIdOrAll(@PathVariable(required = false) Integer id) {
        if (id == null) {
            return ResponseEntity.ok(userService.findAll());
        } else {
            return ResponseEntity.ok(List.of(userService.findById(id)));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestParam UserRequest userRequest) {
        UserResponse response = userService.register(userRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Integer id, @RequestParam UserRequest userRequest) {
        UserResponse response = userService.update(id, userRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable Integer id) {
        UserResponse response = userService.delete(id);
        return ResponseEntity.ok(response);
    }
}
