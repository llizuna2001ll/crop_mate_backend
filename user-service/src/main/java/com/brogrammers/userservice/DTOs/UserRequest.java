package com.brogrammers.userservice.DTOs;

import com.brogrammers.userservice.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

/**
 * DTO for {@link com.brogrammers.userservice.entities.User}
 */

@Data
@Builder
public class UserRequest {
    @NotBlank(message = "Fill the username field!")
    private String username;
    @NotBlank(message = "Fill the password field!")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    @Email(message = "Invalid email address")
    private String email;
    @NotBlank(message = "Fill the address field!")
    private String address;
    @Pattern(regexp="(^$|[0-9]{10})")
    @NotBlank(message = "Fill contact field!")
    private String contactNumber;

    public static UserRequest toUserRequest(User user){
        return UserRequest.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .username(user.getUsername())
                .address(user.getAddress())
                .contactNumber(user.getContactNumber())
                .build();
    }
}