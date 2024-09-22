package br.api.walletapi.domain.exceptions;

public class PinException extends Exception {
    // Attribute
    private String code;

    // Builder
    public PinException(String message, String code) {
        super(message);
        this.code = code;
    }

}
