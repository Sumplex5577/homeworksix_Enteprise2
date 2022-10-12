package com.example.homeworksix.service;

import com.example.homeworksix.dto.CartDto;
import com.example.homeworksix.dto.ProductDto;
import com.example.homeworksix.model.Cart;
import com.example.homeworksix.model.Product;
import com.example.homeworksix.repository.CartRepository;
import com.example.homeworksix.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.homeworksix.converter.CartConverter.convertCartToCartDto;
import static com.example.homeworksix.converter.PersonConverter.convertPersonDtoToPerson;
import static com.example.homeworksix.converter.ProductConverter.convertProductDtoToProduct;


@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final PersonService personService;
    private final ProductService productService;

    public CartServiceImpl(CartRepository cartRepository, PersonService personService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.personService = personService;
        this.productService = productService;
    }

    @Override
    public Long addCartByPersonId(Long personId) {
        Cart cart = new Cart(convertPersonDtoToPerson(personService.getPersonById(personId)));
        personService.getPersonById(personId).getCarts().add(cart);
        return cartRepository.save(cart).getId();
    }

    @Override
    public Long removeCartById(Long id) {
        if (cartRepository.findById(id).isPresent()) {
            Cart cart = cartRepository.findById(id).get();
            personService.getPersonById(cart.getPerson().getId()).getCarts().remove(cart);
            cartRepository.deleteById(id);
            return id;
        }
        try {
            throw new NotFoundException("Cart with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public CartDto getCartById(Long id) {
        if (cartRepository.findById(id).isPresent()) {
            return convertCartToCartDto(cartRepository.findById(id).get());
        }
        try {
            throw new NotFoundException("Cart with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<CartDto> getAllCarts() {
        List<CartDto> cartDtoList = new ArrayList<>();
        cartRepository.findAll().forEach(cart -> cartDtoList.add(convertCartToCartDto(cart)));
        return cartDtoList;
    }

    @Override
    public CartDto addProductByProductId(ProductDto productDto) {
        if (cartRepository.findById(productDto.getCartId()).isPresent()) {
            Cart cart = cartRepository.findById(productDto.getCartId()).get();
            Product product = convertProductDtoToProduct(productService.getProductById(productDto.getId()));
            checkContainsProduct(cart, product);
            cart.getProducts().add(product);
            increaseAmountAndSum(cart, product);
            return convertCartToCartDto(cart);
        }
        try {
            throw new NotFoundException("Cart with ID #" + productDto.getCartId() + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public CartDto removeProductByProductId(ProductDto productDto) {
        if (cartRepository.findById(productDto.getCartId()).isPresent()) {
            Cart cart = cartRepository.findById(productDto.getCartId()).get();
            Product product = convertProductDtoToProduct(productService.getProductById(productDto.getId()));
            checkNotContainsProduct(cart, product);
            decreaseAmountAndSum(cart, product);
            cart.getProducts().remove(product);
            return convertCartToCartDto(cart);
        }
        try {
            throw new NotFoundException("Cart with ID #" + productDto.getCartId() + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Long removeAllProductsById(Long id) {
        if (cartRepository.findById(id).isPresent()) {
            Cart cart = cartRepository.findById(id).get();
            cart.getProducts().clear();
            cart.setSum(new BigDecimal("0.00"));
            cart.setAmountOfProducts(0);
            return id;
        }
        try {
            throw new NotFoundException("Cart with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void checkNotContainsProduct(Cart cart, Product product) {
        if (!cart.getProducts().contains(product)) {
            try {
                throw new NotFoundException("Cart don't contains product with ID #" + product.getId());
            } catch (NotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    private void checkContainsProduct(Cart cart, Product product) {
        if (cart.getProducts().contains(product)) {
            try {
                throw new NotFoundException("Cart is already contains product with ID #" + product.getId());
            } catch (NotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    private void increaseAmountAndSum(Cart cart, Product product) {
        cart.setAmountOfProducts(cart.getAmountOfProducts() + 1);
        cart.setSum(cart.getSum().add(BigDecimal.valueOf(product.getPrice())));
    }

    private void decreaseAmountAndSum(Cart cart, Product product) {
        if (cart.getSum().compareTo(new BigDecimal("0.00")) != 0
                && cart.getAmountOfProducts().compareTo(0) != 0) {
            cart.setAmountOfProducts(cart.getAmountOfProducts() - 1);
            cart.setSum(cart.getSum().subtract(BigDecimal.valueOf(product.getPrice())));
        } else {
            cart.setSum(new BigDecimal("0.00"));
            cart.setAmountOfProducts(0);
        }
    }
}
