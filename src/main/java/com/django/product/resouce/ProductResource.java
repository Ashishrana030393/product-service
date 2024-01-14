package com.django.product.resouce;

import com.django.product.dto.ProductDto;
import com.django.product.entity.Product;
import com.django.product.mapper.ProductMapper;
import com.django.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ProductDto create(@RequestBody ProductDto productDto){
        Product product = this.productService.create(productDto);
        ProductDto response = ProductMapper.INSTANCE.mapToDto(product);
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    ProductDto update( @RequestBody ProductDto productDto){
        Product updatedProduct = this.productService.update(productDto);
        return ProductMapper.INSTANCE.mapToDto(updatedProduct);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{product-id}")
    void delete(@PathVariable("product-id") String productId){
        this.productService.delete(productId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{product-id}")
    ProductDto fetchByProductId(@PathVariable("product-id") String productId){
        Product product = this.productService.findByProductId(productId);
        return ProductMapper.INSTANCE.mapToDto(product);
    }

    @GetMapping("tags")
    List<ProductDto> fetchByTags(@RequestBody List<String> tags){
        List<Product> products  = this.productService.findByTags(tags);
        return ProductMapper.INSTANCE.mapToDto(products);
    }

}
