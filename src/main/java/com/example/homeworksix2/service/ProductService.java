package com.example.homeworksix2.service;

import com.example.homeworksix2.dto.ProductDto;

import java.util.List;

public interface ProductService {
    Long addProduct(ProductDto dto);

    Long removeProductById(Long id);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    Long updateProductNameById(Long id, ProductDto dto);

    Long updateProductPriceById(Long id, ProductDto dto);
}
