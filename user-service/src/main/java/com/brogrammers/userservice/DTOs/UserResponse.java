package com.brogrammers.userservice.DTOs;

import com.brogrammers.userservice.entities.User;
import com.brogrammers.userservice.enums.Roles;
import com.brogrammers.userservice.models.Land;
import lombok.*;

import java.util.List;

/**
 * DTO for {@link com.brogrammers.userservice.entities.User}
 */

@Data
@Builder
public class UserResponse {
    private String username;
    private String email;
    private String address;
    private String contactNumber;
    private Roles role;
    private List<Land> lands;
    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(user.getAddress())
                .contactNumber(user.getContactNumber())
                .role(user.getRole())
                .lands(user.getLands())
                .build();
    }
}