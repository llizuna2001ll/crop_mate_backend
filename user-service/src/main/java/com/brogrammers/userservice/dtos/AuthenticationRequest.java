package com.brogrammers.userservice.dtos;

import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;
}
