package com.example.homeworksix.controller;

import com.example.homeworksix.dto.ShopDto;
import com.example.homeworksix.model.Shop;
import com.example.homeworksix.service.ShopService;
import com.example.homeworksix.utils.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ShopDto createShop(@RequestBody ShopDto shopDto){
        return shopService.createShop(shopDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ShopDto getShopById(@RequestParam Long shopId) throws NotFoundException {
        return shopService.getShopById(shopId);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShop(@RequestParam Long shopId) throws NotFoundException {
        shopService.deleteShop(shopId);

    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ShopDto> getAll() {
        return shopService.getAllShops();
    }
}

