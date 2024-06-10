package com.devmarcotulio.api.dtos;

import com.devmarcotulio.api.entities.Department;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserDto {

    private String name;

    @Email(message = "Email address should be a valid value")
    private String email;

    private Department department;
}
