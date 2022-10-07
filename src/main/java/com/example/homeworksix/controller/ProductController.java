package com.example.homeworksix.controller;

import com.example.homeworksix.dto.ProductDto;
import com.example.homeworksix.model.Product;
import com.example.homeworksix.service.ProductService;
import com.example.homeworksix.utils.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto createProduct(@RequestBody ProductDto productDto) throws NotFoundException {
        return productService.createProduct(productDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getProductById(@RequestParam Long productId) throws NotFoundException {
        return productService.getProductById(productId);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@RequestParam Long productId) throws NotFoundException {
        productService.deleteProduct(productId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getAll() {
        return productService.getAllProducts();
    }
}

