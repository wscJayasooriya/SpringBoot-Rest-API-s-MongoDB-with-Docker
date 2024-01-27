package com.novozy.springbootdockermongodb.dto;

import com.novozy.springbootdockermongodb.model.Features;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String productName;
    private String productId;
    private String brand;
    private Features features;
    private String[] category;
    private double price;
}
