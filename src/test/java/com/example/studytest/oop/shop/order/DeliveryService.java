package com.example.studytest.oop.shop.order;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeliveryService {

    Map<Long, String> deliveryRepository = new HashMap<>();

    public int requestDelivery(Object orderInfo) {
        // business code
        return 1;
    }
}
