package com.example.homeworkfour.service;

import com.example.homeworkfour.dto.ProductDto;
import com.example.homeworkfour.dto.ProductUpdateDto;
import com.example.homeworkfour.model.Product;
import com.example.homeworkfour.utils.exception.NotFoundException;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDto dto) throws NotFoundException;

    Product getProductById(Long productId) throws NotFoundException;

    Product updateProduct(ProductUpdateDto dto);

    Long deleteProduct(Long productId) throws NotFoundException;

    List<Product> getAllProducts();

}
