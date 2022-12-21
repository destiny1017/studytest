package com.example.studytest.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class CacheService {

    private HashMap<Integer, String> dataRepository = new HashMap<>();

    public CacheService() {
        dataRepository.put(1, "1번 데이터");
        dataRepository.put(2, "2번 데이터");
        dataRepository.put(3, "3번 데이터");
    }

    public String execute(int num) {
        String returnData = dataRepository.get(num);
        log.info("execute num = {}, data = {}", num, returnData);
        return returnData;
    }

    public void changeData(int num, String data) {
        dataRepository.put(num, data);
    }
}
