package com.example.homeworksix2.dto;

import com.example.homeworksix2.model.Cart;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Cart> carts;
}