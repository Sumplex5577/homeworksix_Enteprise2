package com.example.homeworksix2.service;

import com.example.homeworksix2.dto.CartDto;
import com.example.homeworksix2.dto.ProductDto;

import java.util.List;

public interface CartService {
    Long addCartByPersonId(Long personId);

    Long removeCartById(Long id);

    CartDto getCartById(Long id);

    List<CartDto> getAllCarts();

    CartDto addProductByProductId(ProductDto productDto);

    CartDto removeProductByProductId(ProductDto productDto);

    Long removeAllProductsById(Long id);

}
