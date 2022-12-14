package com.example.studytest.request.dto;

import lombok.ToString;

@ToString
public class RequestDtoV3 {
    // Getter가 있고 파라미터 생성자는 있으나 기본 생성자는 없는 클래스
    private Long id;
    private String name;

    public RequestDtoV3(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
