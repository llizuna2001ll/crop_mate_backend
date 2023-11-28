package com.brogrammers.userservice.services;

import com.brogrammers.userservice.entities.User;
import com.brogrammers.userservice.enums.Roles;
import com.brogrammers.userservice.exceptions.NonUniqueUsernameException;
import com.brogrammers.userservice.exceptions.UserNotFoundException;
import com.brogrammers.userservice.DTOs.UserRequest;
import com.brogrammers.userservice.DTOs.UserResponse;
import com.brogrammers.userservice.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.brogrammers.userservice.DTOs.UserResponse.toUserResponse;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse getUser(Long id) {
        return toUserResponse(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found")));
    }

    @Override
    public Page<UserResponse> getAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        Page<UserResponse> userResponses = users.map(UserResponse::toUserResponse);
        return userResponses;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new NonUniqueUsernameException("Username already taken");
        }
        User user = User.toUser(userRequest);
        user.setRole(Roles.USER);
        return toUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse addAdmin(UserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new NonUniqueUsernameException("Username already taken");
        }
        User user = User.toUser(userRequest);
        user.setRole(Roles.USER);
        return toUserResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse updateUser(UserRequest updatedUser) {
        User user = User.toUser(updatedUser);
        return UserResponse.toUserResponse(userRepository.save(user));
    }
}
