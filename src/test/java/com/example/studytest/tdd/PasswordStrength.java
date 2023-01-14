package com.example.studytest.tdd;

public enum PasswordStrength {

    DENY("사용불가"),
    WEAK("약함"),
    NORMAL("보통"),
    STRONG("강함");

    private String strengthKr;

    PasswordStrength(String strength) {
        this.strengthKr = strength;
    }
}
