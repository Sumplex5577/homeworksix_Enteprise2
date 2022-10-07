package com.example.homeworksix.converter;

import com.example.homeworksix.dto.CartDto;
import com.example.homeworksix.model.Cart;

public final class CartConverter {

    public static CartDto getCartDtoFromCart(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setCartId(cart.getCartId());
        cartDto.setPerson(cart.getPerson());
        cartDto.setProducts(cart.getProducts());
        cartDto.setSum(cart.getSum());
        return cartDto;
    }

    public static Cart getCartFromCartDto(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setCartId(cartDto.getCartId());
        cart.setPerson(cartDto.getPerson());
        cart.setProducts(cartDto.getProducts());
        cart.setSum(cartDto.getSum());
        return cart;
    }
}
