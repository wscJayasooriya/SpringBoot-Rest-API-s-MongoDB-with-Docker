package com.novozy.springbootdockermongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {

    private String productName;
    @Id
    private String productId;
    private String brand;
    private Features features;
    private String[] category;
    @Field(name = "cost")
    private double price;
}
