package com.example.homeworksix.service;

import com.example.homeworksix.dto.ShopDto;
import com.example.homeworksix.model.Shop;
import com.example.homeworksix.utils.exception.NotFoundException;

import java.util.List;

public interface ShopService {
    ShopDto addShop(String name);

    Long removeShopById(Long id);

    ShopDto getShopById(Long id);

    List<ShopDto> getAllShops();

    Long updateShopNameById(Long id, String name);
}
