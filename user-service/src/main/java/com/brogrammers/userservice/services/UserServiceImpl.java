package com.brogrammers.userservice.services;

import com.brogrammers.userservice.entities.User;
import com.brogrammers.userservice.enums.Roles;
import com.brogrammers.userservice.exceptions.NonUniqueUsernameException;
import com.brogrammers.userservice.exceptions.UserNotFoundException;
import com.brogrammers.userservice.dtos.UserRequest;
import com.brogrammers.userservice.dtos.UserResponse;
import com.brogrammers.userservice.repositories.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import static com.brogrammers.userservice.dtos.UserResponse.toUserResponse;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JavaMailSender mailSender;


    public UserServiceImpl(UserRepository userRepository, JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }

    @Override
    public UserResponse getUser(Long id) {
        return toUserResponse(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found")));
    }

    @Override
    public Page<UserResponse> getAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(UserResponse::toUserResponse);
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

    @Override
    public void resetPasswordRequest(String email) throws MessagingException, UnsupportedEncodingException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new  UserNotFoundException("User Not Found");
        }
        Random random = new Random();
        int min = 1000;
        int max = 9999;
        String code = String.valueOf(random.nextInt(max - min + 1) + min);
        sendVerificationEmail(email, user.getUsername(), code);
        user.setResetPasswordCode(code);
        userRepository.save(user);
    }

    @Override
    public boolean resetPasswordVerification(String code, String email) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new  UserNotFoundException("User Not Found");
        }
        else if(!user.getResetPasswordCode().equals(code))
            return false;
        else {
            user.setResetPasswordCode(null);
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public void sendVerificationEmail(String email, String username, String code)
            throws MessagingException, UnsupportedEncodingException {

        String fromAddress = "heptagrammers@gmail.com";
        String senderName = "CropMate";
        String subject = "Reset Password";
        String content = "Dear " + username + ",<br>"
                + "You requested a confirmation of your password for logging into CropMate<br>"
                + "This address is associated with the login "+email+"<br>"
                + "Verification Code: <strong>"+code+"</strong><br>"
                + "If you did not try to reset your password you can safely ignore this email<br>"
                + "Crop-Mate";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(message);
    }


}
