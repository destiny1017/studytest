package com.example.studytest.tdd;

import lombok.Data;

@Data
public class PasswordValidationDto {
    private String message;
    private PasswordStrength strength;
}
