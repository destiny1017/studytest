package com.example.studytest.oop.shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class ShopTest {

    @Autowired
    OrderService orderService;

    @Test
    @DisplayName("orderTest")
    void orderTest() {
        Map<String, Object> orderInfo = new HashMap<>();
        orderInfo.put("itemId", 1L);
        orderInfo.put("paymentInfo", new Object());
        orderService.order(orderInfo);
    }
}
