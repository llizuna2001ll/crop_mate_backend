package com.brogrammers.userservice.DTOs;

import jakarta.persistence.Entity;
import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;
}
