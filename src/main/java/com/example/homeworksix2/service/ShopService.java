package com.example.homeworksix2.service;

import com.example.homeworksix2.dto.ShopDto;

import java.util.List;

public interface ShopService {
    ShopDto addShop(String name);

    Long removeShopById(Long id);

    ShopDto getShopById(Long id);

    List<ShopDto> getAllShops();

    Long updateShopNameById(Long id, String name);
}
