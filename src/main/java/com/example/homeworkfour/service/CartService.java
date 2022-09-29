package com.example.homeworkfour.service;

import com.example.homeworkfour.model.Cart;
import com.example.homeworkfour.utils.exception.NotFoundException;

import java.util.List;

public interface CartService {

    Cart createCartByPersonId(Long id) throws NotFoundException;

    Cart addProductByProductIdAndCartId(Long productId, Long cartId) throws NotFoundException;

    Cart removeProductByProductIdAndCartId(Long productId, Long cartId) throws NotFoundException;

    Long removeAllProductsFromCartById(Long cartId) throws NotFoundException;

    Cart getCartById(Long id) throws NotFoundException;

    Long removeCartById(Long id) throws NotFoundException;

    List<Cart> getAllCarts();
}

