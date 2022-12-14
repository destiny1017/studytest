package com.example.studytest.request.dto;

import lombok.Data;

@Data
public class RequestDtoV4 {
    // Getter, Setter, 기본 생성자, 파라미터 생성자 모두 존재하는 클래스
    private Long id;
    private String name;

    public RequestDtoV4() {
    }

    public RequestDtoV4(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
