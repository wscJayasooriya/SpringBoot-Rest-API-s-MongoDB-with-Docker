package com.novozy.springbootdockermongodb.controller;

import com.novozy.springbootdockermongodb.dto.ProductDTO;
import com.novozy.springbootdockermongodb.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products/save")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/products/update")
    public ResponseEntity<Void> updateProduct(ProductDTO productDTO) {
        productService.updateProduct(productDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/products/productId/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") String productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> allProducts = productService.getAllProducts();
        HttpHeaders headers = new HttpHeaders();
        headers.add("info", "Getting all Products");
        return new ResponseEntity<>(allProducts, headers, HttpStatus.OK);
    }

    @GetMapping("/products/productId/{productId}")
    public ResponseEntity<ProductDTO> getById(@PathVariable("productId") String productId) {
        ProductDTO productDTO = productService.getById(productId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("info", "Getting Product by : " + productId);
        return ResponseEntity.status(200).headers(headers).body(productDTO);
    }

    @GetMapping("/products/brand/{brand}")
    public ResponseEntity<List<ProductDTO>> getByBrand(@PathVariable("brand") String brand) {
        List<ProductDTO> allProducts = productService.getByBrand(brand);
        HttpHeaders headers = new HttpHeaders();
        headers.add("info", "Getting all Products by Brand : " + brand);
        return new ResponseEntity<>(allProducts, headers, HttpStatus.OK);
    }

    @GetMapping("/products/color")
    public ResponseEntity<List<ProductDTO>> getByColor(@RequestParam("color") String color) {
        List<ProductDTO> allProducts = productService.getByColor(color);
        HttpHeaders headers = new HttpHeaders();
        headers.add("info", "Getting all Products by Color : " + color);
        return new ResponseEntity<>(allProducts, headers, HttpStatus.OK);
    }

    @GetMapping("/products/brand/{brand}/price/{price}")
    public ResponseEntity<List<ProductDTO>> getByBrandAndLesserPrice(@PathVariable("brand") String brand, @PathVariable("price") double price) {
        List<ProductDTO> allProducts = productService.getByBrandAndLesserPrice(brand, price);
        HttpHeaders headers = new HttpHeaders();
        headers.add("info", "Getting all Products by Brand : " + brand + "Less Than Price : " + price);
        return new ResponseEntity<>(allProducts, headers, HttpStatus.OK);
    }
}
