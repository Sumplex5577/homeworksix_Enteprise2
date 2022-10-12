package com.example.homeworksix.controller;

import com.example.homeworksix.dto.CartDto;

import com.example.homeworksix.dto.PersonDto;
import com.example.homeworksix.dto.ProductDto;
import com.example.homeworksix.service.CartService;
import com.example.homeworksix.utils.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cartIndex(Model model) {
        String message = "Cart control page";
        model.addAttribute("message", message);
        return "cartIndex";
    }

    @RequestMapping(value = "/add_cart", method = RequestMethod.GET)
    public String addCartView(Model model) {
        model.addAttribute("person", new PersonDto());
        model.addAttribute("cart", new CartDto());
        return "addCart";
    }

    @RequestMapping(value = "/add_cart", method = RequestMethod.POST)
    public String addCart(@ModelAttribute("person") PersonDto personDto) {
        cartService.addCartByPersonId(personDto.getId());
        return "addCartSuccess";
    }

    @RequestMapping(value = "/remove_cart", method = RequestMethod.GET)
    public String removeCartByIdView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "removeCart";
    }

    @RequestMapping(value = "/remove_cart", method = {RequestMethod.DELETE, RequestMethod.POST})
    @Transactional
    public String removeCartById(@ModelAttribute("cart") CartDto cartDto) {
        cartService.removeCartById(cartDto.getId());
        return "removeCartSuccess";
    }

    @RequestMapping(value = "/get_cart", method = RequestMethod.GET)
    public String getCartById(@RequestParam Long id, Model model) {
        model.addAttribute("cart", cartService.getCartById(id));
        return "getCartSuccess";
    }

    @GetMapping("/all_carts")
    public String getAllCarts(Model model) {
        model.addAttribute("all", cartService.getAllCarts());
        return "allCarts";
    }

    @RequestMapping(value = "/add_product", method = RequestMethod.GET)
    public String addProductByProductIdView(Model model) {
        model.addAttribute("product", new ProductDto());
        return "addProductToCart";
    }

    @RequestMapping(value = "/add_product", method = {RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String addProductByProductId(@ModelAttribute("product") ProductDto productDto) {
        cartService.addProductByProductId(productDto);
        return "addProductToCartSuccess";
    }

    @RequestMapping(value = "/remove_product", method = RequestMethod.GET)
    public String removeProductByProductIdView(Model model) {
        model.addAttribute("product", new ProductDto());
        return "removeProductFromCart";
    }

    @RequestMapping(value = "/remove_product", method = {RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String removeProductByProductId(@ModelAttribute("cart") ProductDto productDto) {
        cartService.removeProductByProductId(productDto);
        return "removeProductFromCartSuccess";
    }

    @RequestMapping(value = "/remove_all", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String removeAllProductsById(@RequestParam Long id, Model model) {
        model.addAttribute("cart", cartService.removeAllProductsById(id));
        return "removeAllProductsById";
    }

}
