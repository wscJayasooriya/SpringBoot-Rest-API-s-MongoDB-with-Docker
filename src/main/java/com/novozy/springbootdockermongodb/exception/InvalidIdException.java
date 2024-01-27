package com.novozy.springbootdockermongodb.exception;

public class InvalidIdException extends RuntimeException{

    public static final long serialVersionUIO = 1L;
    public InvalidIdException() {
        super();
    }

    public InvalidIdException(String message) {
        super(message);
    }
}
