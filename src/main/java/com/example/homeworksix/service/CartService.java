package com.example.homeworksix.service;

import com.example.homeworksix.dto.CartDto;
import com.example.homeworksix.dto.ProductDto;
import com.example.homeworksix.utils.exception.NotFoundException;

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
