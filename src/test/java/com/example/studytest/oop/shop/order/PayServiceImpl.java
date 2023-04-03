package com.example.studytest.oop.shop.order;

import com.example.studytest.oop.shop.module.PaymentApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {

    private final PaymentApi paymentApi;

    public int executePayment(Object paymentInfo) {
        return paymentApi.execute();
    }
}
