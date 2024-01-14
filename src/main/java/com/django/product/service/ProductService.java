package com.django.product.service;

import com.django.product.dto.ProductDto;
import com.django.product.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(ProductDto productDto);

    Product update(ProductDto productDto);

    void delete(String productId);

    Product findByProductId(String productId);

    Product findBySku(String sku);

    List<Product> findByTags(List<String> tags);

    Product findByCategory(String categoryName);

    List<Product> findByGroupId(String groupId);
}
