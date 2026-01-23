package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // ERROR 404: Recurso no encontrado
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFound(ResourceNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("mensaje", ex.getMessage());
        error.put("codigo", "404");
        error.put("error", "No encontrado");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // ERROR 400: Validación fallida
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        errors.put("codigo", "400");
        errors.put("error", "Validación fallida");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // MANEJA ERROR DE CÉDULA DUPLICADA -
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleCedulaDuplicada(DataIntegrityViolationException ex) {
        Map<String, String> error = new HashMap<>();

        error.put("mensaje", "La cédula ya está registrada en el sistema");
        error.put("codigo", "409");
        error.put("error", "Cédula duplicada");
        error.put("detalle", "No se puede guardar porque la cédula ya existe");

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    // ERROR 500: Error interno del servidor
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("mensaje", "Error interno del servidor");
        error.put("detalle", ex.getMessage());
        error.put("codigo", "500");
        error.put("error", "Error interno");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}