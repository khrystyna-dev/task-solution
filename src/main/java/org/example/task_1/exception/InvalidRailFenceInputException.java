package org.example.task_1.exception;

public class InvalidRailFenceInputException extends RuntimeException {
    public InvalidRailFenceInputException(String message) {
        super(message);
    }
}