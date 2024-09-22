package br.api.walletapi.domain.exceptions;

public class AuthenticateException extends Exception {
    // Attribute
    private String code;

    // Builder
    public AuthenticateException(String message, String code) {
        super(message);
        this.code = code;
    }

}
