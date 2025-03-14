package com.dovskyy.korepetor.service;

import com.dovskyy.korepetor.dto.request.UserRegisterRequest;
import com.dovskyy.korepetor.dto.response.UserRegisterResponse;
import com.dovskyy.korepetor.entity.User;
import com.dovskyy.korepetor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegisterResponse registerUser(UserRegisterRequest registerRequest){
        if (userRepository.existsByEmail(registerRequest.getEmail())){
            throw new IllegalArgumentException("User with this email already exists");
        }

        User user = User.builder()
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .phone(registerRequest.getPhone())
                .role(registerRequest.getRole())
                .active(true)
                .build();

        User savedUser = userRepository.save(user);

        return mapToRegisterResponse(savedUser);

    }

    private UserRegisterResponse mapToRegisterResponse(User savedUser) {
        return UserRegisterResponse.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .phone(savedUser.getPhone())
                .role(savedUser.getRole())
                .createdAt(savedUser.getCreatedAt())
                .build();
    }
}
