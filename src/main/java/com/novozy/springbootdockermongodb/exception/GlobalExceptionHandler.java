package com.novozy.springbootdockermongodb.exception;

import com.novozy.springbootdockermongodb.dto.ApiError;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        headers.add("info", "Method not supported");
        int statusCode = status.value();
        String error = ex.getMessage();
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
        ApiError apiError = new ApiError(LocalDateTime.now(), statusCode, error, httpStatus);
        return ResponseEntity.status(status).headers(headers).body(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        headers.add("info", "Media type not supported");
        int statusCode = status.value();
        String error = ex.getMessage();
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
        ApiError apiError = new ApiError(LocalDateTime.now(), statusCode, error, httpStatus);
        return ResponseEntity.status(status).headers(headers).body(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        headers.add("info", "Path variable is Missing");
        int statusCode = status.value();
        String error = ex.getMessage();
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
        ApiError apiError = new ApiError(LocalDateTime.now(), statusCode, error, httpStatus);
        return ResponseEntity.status(status).headers(headers).body(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        headers.add("info", "Request Param variable name does not match");
        int statusCode = status.value();
        String error = ex.getMessage();
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
        ApiError apiError = new ApiError(LocalDateTime.now(), statusCode, error, httpStatus);
        return ResponseEntity.status(status).headers(headers).body(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        headers.add("info", "Type mismatch");
        int statusCode = status.value();
        String error = ex.getMessage();
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
        ApiError apiError = new ApiError(LocalDateTime.now(), statusCode, error, httpStatus);
        return ResponseEntity.status(status).headers(headers).body(apiError);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    protected ResponseEntity<Object> handleProductNotFound(ProductNotFoundException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("info", ex.getMessage());
        HttpStatus httpStatus = HttpStatus.NO_CONTENT;
        String error = ex.getMessage();
        int statusCode = httpStatus.value();
        ApiError apiError = new ApiError(LocalDateTime.now(), statusCode, error, httpStatus);
        return ResponseEntity.status(HttpStatus.valueOf(statusCode)).headers(headers).body(apiError);
    }

    @ExceptionHandler(InvalidIdException.class)
    protected ResponseEntity<Object> handleInvalidId(InvalidIdException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("info", ex.getMessage());
        HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;
        String error = ex.getMessage();
        int statusCode = httpStatus.value();
        ApiError apiError = new ApiError(LocalDateTime.now(), statusCode, error, httpStatus);
        return ResponseEntity.status(HttpStatus.valueOf(statusCode)).headers(headers).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("info", ex.getMessage());
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String error = ex.getMessage();
        int statusCode = httpStatus.value();
        ApiError apiError = new ApiError(LocalDateTime.now(), statusCode, error, httpStatus);
        return ResponseEntity.status(HttpStatus.valueOf(statusCode)).headers(headers).body(apiError);
    }
}
