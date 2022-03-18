package com.example.springmongojson.repository;

public interface CustomItemRepository {
    void updateItemQuantity(String name, float newQuantity);
}
