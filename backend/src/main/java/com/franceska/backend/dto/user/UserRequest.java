package com.franceska.backend.dto.user;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
    private String email;
    private String password;
    private String username;
}
