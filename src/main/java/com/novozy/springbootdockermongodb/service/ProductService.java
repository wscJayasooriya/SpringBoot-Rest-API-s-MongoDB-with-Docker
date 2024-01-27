package com.novozy.springbootdockermongodb.service;

import com.novozy.springbootdockermongodb.dto.ProductDTO;
import com.novozy.springbootdockermongodb.exception.InvalidIdException;
import com.novozy.springbootdockermongodb.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    void addProduct(ProductDTO productDTO);
    void updateProduct(ProductDTO productDTO);
    void deleteProduct(String productId);
    List<ProductDTO> getAllProducts();
    ProductDTO getById(String productId) throws InvalidIdException;
    List<ProductDTO> getByBrand(String brand) throws InvalidIdException;
    List<ProductDTO> getByColor(String color) throws InvalidIdException;
    List<ProductDTO> getByBrandAndLesserPrice(String brand, double price) throws ProductNotFoundException;
}
