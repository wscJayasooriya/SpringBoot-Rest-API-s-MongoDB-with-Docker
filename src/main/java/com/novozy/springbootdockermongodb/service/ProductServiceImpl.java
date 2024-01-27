package com.novozy.springbootdockermongodb.service;

import com.novozy.springbootdockermongodb.dto.ProductDTO;
import com.novozy.springbootdockermongodb.exception.InvalidIdException;
import com.novozy.springbootdockermongodb.exception.ProductNotFoundException;
import com.novozy.springbootdockermongodb.mapper.ProductMapper;
import com.novozy.springbootdockermongodb.model.Product;
import com.novozy.springbootdockermongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = productMapper.convertToEntity(productDTO);
        productRepository.insert(product);
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        Product product = productMapper.convertToEntity(productDTO);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> dtoList = productList.stream()
                .map(product -> productMapper.convertToDto(product))
                .toList();
        return dtoList;
    }

    @Override
    public ProductDTO getById(String productId) throws InvalidIdException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> {
                    throw new InvalidIdException();
                });
        ProductDTO productDTO = productMapper.convertToDto(product);
        return productDTO;
    }

    @Override
    public List<ProductDTO> getByBrand(String brand) throws InvalidIdException {
        List<Product> productList = productRepository.findByBrand(brand);
        if (productList.isEmpty())
            throw new ProductNotFoundException("Not Products this Brand");
        List<ProductDTO> dtoList = productList.stream()
                .map(product -> productMapper.convertToDto(product))
                .toList();
        return dtoList;
    }

    @Override
    public List<ProductDTO> getByColor(String color) throws InvalidIdException {
        List<Product> productList = productRepository.findByFeaturesColor(color);
        if (productList.isEmpty())
            throw new ProductNotFoundException("Not Products this Color");
        List<ProductDTO> dtoList = productList.stream()
                .map(product -> productMapper.convertToDto(product))
                .toList();
        return dtoList;
    }

    @Override
    public List<ProductDTO> getByBrandAndLesserPrice(String brand, double price) throws ProductNotFoundException {
        List<Product> productList = productRepository.findByBrandAndPriceLessThan(brand, price);
        if (productList.isEmpty())
            throw new ProductNotFoundException("Not Products this Brand and Less Than Price");
        List<ProductDTO> dtoList = productList.stream()
                .map(product -> productMapper.convertToDto(product))
                .toList();
        return dtoList;
    }
}
