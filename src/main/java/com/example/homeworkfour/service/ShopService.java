package com.example.homeworkfour.service;

import com.example.homeworkfour.model.Shop;
import com.example.homeworkfour.utils.exception.NotFoundException;

import java.util.List;

public interface ShopService {

    Shop createShop(Shop shop);

    Long deleteShop(Long shopId) throws NotFoundException;

    Shop getShopById(Long shopId) throws NotFoundException;

    List<Shop> getAllShops();
}
