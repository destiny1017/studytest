package com.example.studytest.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TddExample {

    @Test
    @DisplayName("Null 입력값이 들어오면 NullPointerException 발생")
    void nullInputValidation() {
        String input = null;
        PasswordUtil passwordUtil = new PasswordUtil();
        assertThatNullPointerException().isThrownBy(() -> passwordUtil.passwordCheck(input));
    }

    @Test
    @DisplayName("비어있는 입력값이 들어오면 IllegalArgumentException 발생")
    void emptyInputValidation() {
        String input = "";
        PasswordUtil passwordUtil = new PasswordUtil();
        assertThatIllegalArgumentException().isThrownBy(() -> passwordUtil.passwordCheck(input));
    }

    @Test
    @DisplayName("너무 짧은 입력값(8자리 이하)이 들어오면 불가능 코드 리턴")
    void tooShortInputValidation() {
        String input = "abcd123";
        PasswordUtil passwordUtil = new PasswordUtil();
        PasswordValidationDto result = passwordUtil.passwordCheck(input);
        assertThat(result.getMessage()).isEqualTo("패스워드가 너무 짧습니다!(8자 이상 입력 필요)");
        assertThat(result.getStrength()).isEqualTo(PasswordStrength.DENY);
    }

    @Test
    @DisplayName("너무 긴 입력값(16자리 이상)이 들어오면 불가능 코드 리턴")
    void tooLongInputValidation() {
        String input = "abcd1234abcd1234G";
        PasswordUtil passwordUtil = new PasswordUtil();
        PasswordValidationDto result = passwordUtil.passwordCheck(input);
        assertThat(result.getMessage()).isEqualTo("패스워드가 너무 깁니다!(16자 이하 입력 필요)");
        assertThat(result.getStrength()).isEqualTo(PasswordStrength.DENY);
    }



}
