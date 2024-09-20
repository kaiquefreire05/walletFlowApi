package br.api.walletapi.domain.exceptions;

public class InternalServerErrorException extends Exception {
    // Attribute
    private String code;

    // Builder
    public InternalServerErrorException(String message, String code) {
        super(message);
        this.code = code;
    }

}
