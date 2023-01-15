package com.example.studytest.tdd;

public class PasswordUtil {

    final String TOO_SHORT = "패스워드가 너무 짧습니다!(8자 이상 입력 필요)";
    final String TOO_LONG = "패스워드가 너무 깁니다!(16자 이하 입력 필요)";
    final String NO_NUMBER = "숫자가 포함되어야 합니다";
    final String NO_SPECIAL_CHAR = "특수문자가 포함되어야 합니다";
    final String WEAK_PASSWORD = "보안 수준이 약한 비밀번호입니다";
    final String NORMAL_PASSWORD = "보안 수준이 적당한 비밀번호입니다";
    final String STRONG_PASSWORD = "보안 수준이 강력한 비밀번호입니다";

    public PasswordValidationDto passwordCheck(String input) {
        PasswordValidationDto validDto = passwordValidate(input);
        return validDto;
    }

    private PasswordValidationDto passwordValidate(String input) {
        PasswordValidationDto dto = new PasswordValidationDto();
        if(input == null) {
            throw new NullPointerException();
        } else if(input.length() <= 0) {
            throw new IllegalArgumentException();
        } else if(input.length() < 8) {
            dto.setMessage(TOO_SHORT);
            dto.setStrength(PasswordStrength.DENY);
        } else if(input.length() > 16) {
            dto.setMessage(TOO_LONG);
            dto.setStrength(PasswordStrength.DENY);
        } else if(!input.matches("^.*[\\d].*$")) {
            dto.setMessage(NO_NUMBER);
            dto.setStrength(PasswordStrength.DENY);
        } else if(!input.matches("^.*[$@$!%*#?&].*$")) {
            dto.setMessage(NO_SPECIAL_CHAR);
            dto.setStrength(PasswordStrength.DENY);
        } else {
            dto = strengthCheck(input, dto);
        }
        return dto;
    }

    private PasswordValidationDto strengthCheck(String input, PasswordValidationDto dto) {
        if(input.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*#?&]{12,}")) {
            dto.setStrength(PasswordStrength.STRONG);
            dto.setMessage(STRONG_PASSWORD);
        } else if(input.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}")
        || input.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{12,}$")) {
            dto.setStrength(PasswordStrength.NORMAL);
            dto.setMessage(NORMAL_PASSWORD);
        } else {
            dto.setStrength(PasswordStrength.WEAK);
            dto.setMessage(WEAK_PASSWORD);
        }
        return dto;
    }

}
