package com.example.homeworksix.service;

import com.example.homeworksix.dto.ShopDto;
import com.example.homeworksix.model.Shop;
import com.example.homeworksix.utils.exception.NotFoundException;

import java.util.List;

public interface ShopService {

    ShopDto createShop(ShopDto shopDto);

    void deleteShop(Long shopId) throws NotFoundException;

    ShopDto getShopById(Long shopId) throws NotFoundException;

    List<ShopDto> getAllShops();
}
