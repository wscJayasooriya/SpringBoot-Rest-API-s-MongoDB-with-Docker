package com.novozy.springbootdockermongodb.mapper;

import com.novozy.springbootdockermongodb.dto.ProductDTO;
import com.novozy.springbootdockermongodb.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO convertToDto(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setBrand(product.getBrand());
        productDTO.setCategory(product.getCategory());
        productDTO.setFeatures(product.getFeatures());
        productDTO.setPrice(product.getPrice());

        return productDTO;
    }

    public Product convertToEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setBrand(productDTO.getBrand());
        product.setCategory(productDTO.getCategory());
        product.setFeatures(productDTO.getFeatures());
        product.setPrice(productDTO.getPrice());

        return product;
    }
}
