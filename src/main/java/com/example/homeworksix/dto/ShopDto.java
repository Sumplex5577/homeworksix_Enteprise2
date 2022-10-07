package com.example.homeworksix.dto;

import com.example.homeworksix.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopDto {

    private Long id;
    private String name;
    private String address;
    private List<Product> products;
}
