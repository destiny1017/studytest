package com.example.studytest.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExamTest {

    ExamService examService;

    @Test
    void examTest() {
        examService = new ExamService(new ExamRepository(), new ExamRepository2());
        int result = examService.addInfo(new ExamInfo());
        Assertions.assertThat(result).isEqualTo(1);
        System.out.println("result = " + result);
    }
}
