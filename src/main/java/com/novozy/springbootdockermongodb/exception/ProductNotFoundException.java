package com.novozy.springbootdockermongodb.exception;

public class ProductNotFoundException extends RuntimeException{

    public static final long serialVersionUIO = 1L;
    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
