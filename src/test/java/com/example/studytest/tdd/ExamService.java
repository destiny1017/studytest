package com.example.studytest.tdd;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

    @Service
    @RequiredArgsConstructor
    public class ExamService {

        private final ExamRepository examRepository;
        private final ExamRepository2 examRepository2;

        public int addInfo(ExamInfo info) {
            List<String> sampleList = new ArrayList();
            for(SampleObj sample : info.getSampleList()) {
                sampleList.add(sample.getName());
            }
            return examRepository.addSamples(sampleList);
        }
    }


@Repository
class ExamRepository {
    public int addSamples(List<String> sampleList) {
        return 1;
    }
}

@Repository
class ExamRepository2 {

}

class ExamInfo {
    private List<SampleObj> sampleList = new ArrayList<>();
    public List<SampleObj> getSampleList() {return this.sampleList;}
}

class SampleObj {
    public String getName() {
        return "    ";
    }
}