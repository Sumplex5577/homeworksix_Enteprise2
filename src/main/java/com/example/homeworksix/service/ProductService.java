package com.example.homeworksix.service;

import com.example.homeworksix.dto.ProductDto;
import com.example.homeworksix.model.Product;
import com.example.homeworksix.utils.exception.NotFoundException;

import java.util.List;

public interface ProductService {
    Long addProduct(ProductDto dto);

    Long removeProductById(Long id);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    Long updateProductNameById(Long id, ProductDto dto);

    Long updateProductPriceById(Long id, ProductDto dto);
}
