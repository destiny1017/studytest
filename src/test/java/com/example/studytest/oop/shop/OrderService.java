package com.example.studytest.oop.shop;

import com.example.studytest.oop.shop.order.DeliveryService;
import com.example.studytest.oop.shop.order.PayService;
import com.example.studytest.oop.shop.order.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final DeliveryService deliveryService;
    private final PayService payService;
    private final StockService stockService;

    public int order(Map<String, Object> orderInfo) {
        Long itemId = (Long) orderInfo.get("itemId");
        log.info("order > itemId={}", itemId);
        if(stockService.getStock(itemId) > 0) {
            int paymentResult = payService.executePayment(orderInfo.get("paymentInfo"));
            log.info("order > paymentResult = {}", paymentResult);
            if(paymentResult == 1) {
                int delResult = stockService.delStock(itemId);
                log.info("order > delStockResult = {}", delResult);
                return deliveryService.requestDelivery(orderInfo);
            }
        }
        return 0;
    }
}
