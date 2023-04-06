package com.example.studytest.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExamMockTest {

    @InjectMocks
    ExamService examService;

    @Mock
    ExamRepository examRepository;

    @Test
    void mockTest() {
        List<String> strings = new ArrayList<>();
        Mockito.when(examRepository.addSamples(strings)).thenReturn(1);

        int result = examService.addInfo(new ExamInfo());

        Assertions.assertThat(result).isEqualTo(1);
        System.out.println("result = " + result);

    }

}
