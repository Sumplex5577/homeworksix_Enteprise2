package com.example.homeworksix.service;

import com.example.homeworksix.dto.CartDto;
import com.example.homeworksix.model.Cart;
import com.example.homeworksix.utils.exception.NotFoundException;

import java.util.List;

public interface CartService {

    CartDto createCartByPersonId(Long Id) throws NotFoundException;

    CartDto addProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException;

    CartDto removeProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException;

    void removeAllProductsFromCartById(Long cartId) throws NotFoundException;

    CartDto getCartById(Long id) throws NotFoundException;

    void removeCartById(Long id) throws NotFoundException;

    List<CartDto> getAllCarts();
}
