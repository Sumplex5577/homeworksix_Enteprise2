package com.example.homeworksix.converter;

import com.example.homeworksix.dto.ShopDto;
import com.example.homeworksix.model.Shop;

public final class ShopConverter {

    public static ShopDto getShopDtoFromShop(Shop shop) {
        ShopDto shopDto = new ShopDto();
        shopDto.setId(shop.getId());
        shopDto.setName(shop.getName());
        shopDto.setAddress(shop.getAddress());
        shopDto.setProducts(shop.getProducts());
        return shopDto;
    }

    public static Shop getShopFromShopDto(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setId(shopDto.getId());
        shop.setName(shopDto.getName());
        shop.setAddress(shopDto.getAddress());
        shop.setProducts(shopDto.getProducts());
        return shop;
    }
}
