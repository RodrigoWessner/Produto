package br.com.compass.produtos.exceptions;

public class DefaultErrorDto {
    private String errorMessage;

    public DefaultErrorDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
