package com.example.studytest.oop.shop.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StockService {

    Map<Long, Integer> stockRepository = new HashMap<>();

    public int addStock(Long id) {
        stockRepository.put(id, stockRepository.get(id) + 1);
        return stockRepository.get(id);
    }

    public int delStock(Long id) {
        stockRepository.put(id, stockRepository.get(id) - 1);
        return stockRepository.get(id);
    }

    public int getStock(Long id) {
        return stockRepository.get(id);
    }

    @PostConstruct
    private void postConstruct() {
        stockRepository.put(1L, 10);
        System.out.println("stocked 10 number of item of 1L..");
    }
}
