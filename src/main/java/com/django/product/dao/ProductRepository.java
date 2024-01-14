package com.django.product.dao;

import com.django.product.entity.Product;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
    Product save(Product product);
    @Query("value={'productId': ?0}")
    Product findByProductId(String productId);
    @DeleteQuery(value= "{'_id': ?0}" )
    void deleteById(String productId);
    @Query("value={'sku': ?0}")
    Product findBySku(String sku);
    @Query("value={'tags': { $in : ?0 } }")
    List<Product> findProductByTags(List<String> tags);
    @Query("value={'category.name': ?0}")
    Product findByCategory(String categoryName);
    @Query("value={'groupId': ?0}")
    List<Product> findByGroupId(String groupId);
}
