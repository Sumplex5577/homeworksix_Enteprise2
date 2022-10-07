package com.example.homeworksix.converter;

import com.example.homeworksix.dto.ProductDto;
import com.example.homeworksix.model.Product;

public final class ProductConverter {

    public static ProductDto getProductDtoFromProduct (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setShopId(product.getShop().getId());
        productDto.setProductId(product.getId());
        productDto.setShop(product.getShop());
        return productDto;
    }

    public static Product getProductFromProductDto (ProductDto productDto) {
        Product product = new Product ();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setId(productDto.getProductId());
        product.setShop(productDto.getShop());
        return product;
    }
}