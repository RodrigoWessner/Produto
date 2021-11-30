package br.com.compass.produtos.exceptions;

public class NotFound extends RuntimeException {
    public NotFound(String message) {
        super(message);
    }
}
