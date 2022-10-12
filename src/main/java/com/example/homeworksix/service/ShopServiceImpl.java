package com.example.homeworksix.service;

import com.example.homeworksix.dto.ShopDto;
import com.example.homeworksix.model.Shop;
import com.example.homeworksix.repository.ShopRepository;
import com.example.homeworksix.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.homeworksix.converter.ShopConverter.*;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public ShopDto addShop(String name) {
        return convertShopToShopDto(shopRepository.save(new Shop(name)));
    }

    @Override
    public Long removeShopById(Long id) {
        if (shopRepository.existsById(id)) {
            shopRepository.deleteById(id);
            return id;
        }
        try {
            throw new NotFoundException("Shop with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public ShopDto getShopById(Long id) {
        if (shopRepository.findById(id).isPresent()) {
            return convertShopToShopDto(shopRepository.findById(id).get());
        }
        try {
            throw new NotFoundException("Shop with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<ShopDto> getAllShops() {
        List<ShopDto> shopDtoList = new ArrayList<>();
        shopRepository.findAll().forEach(shop -> shopDtoList.add(convertShopToShopDto(shop)));
        return shopDtoList;
    }

    @Override
    public Long updateShopNameById(Long id, String name) {
        if (shopRepository.existsById(id)) {
            return Long.valueOf(shopRepository.updateNameById(id, name));
        }
        try {
            throw new NotFoundException("Shop with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}