package com.example.homeworksix2.dto;

import com.example.homeworksix2.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopDto {
    private Long id;
    private String name;
    private List<Product> products;

}
