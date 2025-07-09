package com.dev.validatiom.dto;

import com.dev.validatiom.validation.NoSpecialChar;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank(message = "username is required")
    public String username;

    @Email(message = "invalid email format")
    public String email;

    @Size(min = 6, message = "password must be at least 6 character")
    public String password;

    @NoSpecialChar
    private String firstname;


}
