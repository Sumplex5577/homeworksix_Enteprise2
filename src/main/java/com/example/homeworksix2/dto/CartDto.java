package com.example.homeworksix2.dto;

import com.example.homeworksix2.model.Person;
import com.example.homeworksix2.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CartDto {
    private Long id;
    private Person person;
    private List<Product> products;
    private Integer amountOfProducts;
    private BigDecimal sum;
}

