package com.brogrammers.userservice.entities;
import com.brogrammers.userservice.enums.Roles;
import com.brogrammers.userservice.models.Land;
import com.brogrammers.userservice.DTOs.UserRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String contactNumber;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime creationTime = LocalDateTime.now();

    @Transient
    private List<Land> lands = new ArrayList<>();


    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }


    public static User toUser(UserRequest userRequest){
        return User.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .address(userRequest.getAddress())
                .contactNumber(userRequest.getContactNumber())
                .build();
    }
}

