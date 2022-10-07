package com.example.homeworksix.dto;

import com.example.homeworksix.model.Shop;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String name;

    private Double price;

    private Long shopId;

    private Long productId;

    private Shop shop;
}
