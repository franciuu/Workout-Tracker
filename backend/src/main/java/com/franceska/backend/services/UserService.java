package com.franceska.backend.services;

import com.franceska.backend.dto.user.UserRequest;
import com.franceska.backend.dto.user.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> read();
    UserResponse createUser(UserRequest request);
}
