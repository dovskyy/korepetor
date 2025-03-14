package com.dovskyy.korepetor.dto.request;

import com.dovskyy.korepetor.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterRequest {

    @NotBlank
    @Email(message = "Please provide a valid email")
    private String email;

    @NotBlank
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;

    @NotBlank
    @Size(max = 50, message = "First name must be less than 50 characters")
    private String firstName;

    @NotBlank
    @Size(max = 50, message = "Last name must be less than 50 characters")
    private String lastName;

    @Size(min = 3, max = 20, message = "Phone number must be between 3 and 20 characters")
    private String phone;

    private UserRole role = UserRole.STUDENT;
}
