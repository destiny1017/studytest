package com.example.studytest.tdd;

public class PasswordUtil {

    public PasswordValidationDto passwordCheck(String input) {
        PasswordValidationDto dto = new PasswordValidationDto();
        if(input == null) {
            throw new NullPointerException();
        } else if(input.length() <= 0) {
            throw new IllegalArgumentException();
        } else if(input.length() < 8) {
            dto.setMessage("패스워드가 너무 짧습니다!(8자 이상 입력 필요)");
            dto.setStrength(PasswordStrength.DENY);
        } else if(input.length() > 16) {
            dto.setMessage("패스워드가 너무 깁니다!(16자 이하 입력 필요)");
            dto.setStrength(PasswordStrength.DENY);
        }
        return dto;
    }

}
