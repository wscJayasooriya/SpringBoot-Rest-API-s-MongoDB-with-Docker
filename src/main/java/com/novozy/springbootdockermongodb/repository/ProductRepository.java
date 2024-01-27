package com.novozy.springbootdockermongodb.repository;

import com.novozy.springbootdockermongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByBrand(String brand);
    List<Product> findByFeaturesColor(String color);
    List<Product> findByBrandAndPriceLessThan(String brand, double price);
}
