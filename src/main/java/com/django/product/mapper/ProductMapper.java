package com.django.product.mapper;

import com.django.product.dto.ProductDto;
import com.django.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto mapToDto(Product product);
    Product mapToEntity(ProductDto product);
    List<ProductDto> mapToDto(List<Product> products);

    List<Product> mapToEntity(List<ProductDto> products);
}