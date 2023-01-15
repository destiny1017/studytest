package com.example.studytest.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TddExample {

    PasswordUtil passwordUtil = new PasswordUtil();

    @Test
    @DisplayName("Null 입력값이 들어오면 NullPointerException 발생")
    void nullInputValidation() {
        String input = null;
        assertThatNullPointerException().isThrownBy(() -> passwordUtil.passwordCheck(input));
    }

    @Test
    @DisplayName("비어있는 입력값이 들어오면 IllegalArgumentException 발생")
    void emptyInputValidation() {
        String input = "";
        assertThatIllegalArgumentException().isThrownBy(() -> passwordUtil.passwordCheck(input));
    }

    @Test
    @DisplayName("너무 짧은 입력값(8자리 이하)이 들어오면 DENY")
    void tooShortInputValidation() {
        String input = "abcd123";
        PasswordValidationDto result = passwordUtil.passwordCheck(input);
        assertThat(result.getMessage()).isEqualTo(passwordUtil.TOO_SHORT);
        assertThat(result.getStrength()).isEqualTo(PasswordStrength.DENY);
    }

    @Test
    @DisplayName("너무 긴 입력값(16자리 이상)이 들어오면 DENY")
    void tooLongInputValidation() {
        String input = "abcd1234abcd1234G";
        PasswordValidationDto result = passwordUtil.passwordCheck(input);
        assertThat(result.getMessage()).isEqualTo(passwordUtil.TOO_LONG);
        assertThat(result.getStrength()).isEqualTo(PasswordStrength.DENY);
    }

    @Test @DisplayName("숫자가 포함되지 않은 입력값이 들어오면 DENY")
    void noUppercaseValidation() {
        String input = "abcdsdfeA";
        PasswordValidationDto result = passwordUtil.passwordCheck(input);
        assertThat(result.getMessage()).isEqualTo(passwordUtil.NO_NUMBER);
        assertThat(result.getStrength()).isEqualTo(PasswordStrength.DENY);
    }

    @Test @DisplayName("특수문자가 포함되지 않은 입력값이 들어오면 DENY")
    void noSpecialCharValidation() {
        String input = "sdfsdf3435";
        PasswordValidationDto result = passwordUtil.passwordCheck(input);
        assertThat(result.getMessage()).isEqualTo(passwordUtil.NO_SPECIAL_CHAR);
        assertThat(result.getStrength()).isEqualTo(PasswordStrength.DENY);
    }
    
    @Test @DisplayName("최소조건 충족 입력값이 들어오면 WEAK")
    void fitInput() {
        String input = "asdasd1@";
        PasswordValidationDto result = passwordUtil.passwordCheck(input);
        assertThat(result.getMessage()).isEqualTo(passwordUtil.WEAK_PASSWORD);
        assertThat(result.getStrength()).isEqualTo(PasswordStrength.WEAK);
    }

    @Test @DisplayName("8자 이상, 4가지 문자조합 입력값이 들어오면 NORMAL")
    void normalInputTest1() {
        String input = "asdasD1@";
        PasswordValidationDto result = passwordUtil.passwordCheck(input);
        assertThat(result.getMessage()).isEqualTo(passwordUtil.NORMAL_PASSWORD);
        assertThat(result.getStrength()).isEqualTo(PasswordStrength.NORMAL);
    }

    @Test @DisplayName("12자 이상, 3가지 이하 문자조합이 입력값이 들어오면 NORMAL")
    void normalInputTest2() {
        String input = "asdasd12243@#";
        PasswordValidationDto result = passwordUtil.passwordCheck(input);
        assertThat(result.getMessage()).isEqualTo(passwordUtil.NORMAL_PASSWORD);
        assertThat(result.getStrength()).isEqualTo(PasswordStrength.NORMAL);
    }

    @Test @DisplayName("12자 이상, 4가지 이상 문자조합이 입력값이 들어오면 STRONG")
    void strongInputTest() {
        String input = "asdasd12243@#D";
        PasswordValidationDto result = passwordUtil.passwordCheck(input);
        assertThat(result.getMessage()).isEqualTo(passwordUtil.STRONG_PASSWORD);
        assertThat(result.getStrength()).isEqualTo(PasswordStrength.STRONG);
    }


}
