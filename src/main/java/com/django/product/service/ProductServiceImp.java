package com.django.product.service;

import com.django.product.dao.ProductRepository;
import com.django.product.dto.ProductDto;
import com.django.product.entity.Product;
import com.django.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(ProductDto productDto){
        Product product = ProductMapper.INSTANCE.mapToEntity(productDto);
        Product save = this.productRepository.save(product);
        return save;
    }

    @Override
    public Product update(ProductDto productDto){
        Product newProduct = ProductMapper.INSTANCE.mapToEntity(productDto);
        Product oldProduct = this.productRepository.findByProductId(productDto.getProductId());
        newProduct.setId(oldProduct.getId());
        return this.productRepository.save(oldProduct);
    }

    @Override
    public void delete(String productId){
        this.productRepository.deleteById(productId);
    }

    @Override
    public Product findByProductId(String productId){
        return this.productRepository.findByProductId(productId);
    }

    @Override
    public Product findBySku(String sku){
        return this.productRepository.findBySku(sku);
    }

    @Override
    public List<Product> findByTags(List<String> tags){
        return this.productRepository.findProductByTags(tags);
    }

    @Override
    public Product findByCategory(String categoryName){
        return this.productRepository.findByCategory(categoryName);
    }

    @Override
    public List<Product> findByGroupId(String groupId){
       return  this.productRepository.findByGroupId(groupId);
    }
}
