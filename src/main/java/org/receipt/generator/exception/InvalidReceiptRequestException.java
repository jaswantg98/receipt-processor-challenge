package org.receipt.generator.exception;

public class InvalidReceiptRequestException extends RuntimeException {
    public InvalidReceiptRequestException(String message) {
        super(message);
    }
}
