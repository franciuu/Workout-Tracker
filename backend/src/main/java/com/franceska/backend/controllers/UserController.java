package com.franceska.backend.controllers;

import com.franceska.backend.dto.user.UserRequest;
import com.franceska.backend.dto.user.UserResponse;
import com.franceska.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse addUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return userService.read();
    }
}
