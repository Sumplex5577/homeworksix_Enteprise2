package com.example.homeworksix.service;

import com.example.homeworksix.dto.ProductDto;
import com.example.homeworksix.model.Product;
import com.example.homeworksix.utils.exception.NotFoundException;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto) throws NotFoundException;

    ProductDto getProductById(Long productId) throws NotFoundException;

    ProductDto updateProduct(ProductDto productDto);

    void deleteProduct(Long productId) throws NotFoundException;

    List<ProductDto> getAllProducts();

}