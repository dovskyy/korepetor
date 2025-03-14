package com.dovskyy.korepetor.controller;

import com.dovskyy.korepetor.dto.request.UserRegisterRequest;
import com.dovskyy.korepetor.dto.response.UserRegisterResponse;
import com.dovskyy.korepetor.service.UserService;
import jakarta.persistence.EntityExistsException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to handle user-related APIs.
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public String getAllUsers() {
        // TODO: Replace with service call to fetch and return actual users
        return "List of all users";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterRequest registerRequest) {
        try {
            UserRegisterResponse userResponse = userService.registerUser(registerRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
        } catch (EntityExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "An error occurred during registration"));
        }
    }

}
