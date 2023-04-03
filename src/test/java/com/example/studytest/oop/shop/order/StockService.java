package com.example.studytest.oop.shop.order;

public interface StockService {
    int addStock(Long itemId);
    int delStock(Long itemId);
    int getStock(Long itemId);
}
