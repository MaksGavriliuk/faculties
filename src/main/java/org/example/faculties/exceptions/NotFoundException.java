package org.example.faculties.exceptions;


public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Не удалось найти ресурс");
    }

    public NotFoundException(String message) {
        super(message);
    }
}