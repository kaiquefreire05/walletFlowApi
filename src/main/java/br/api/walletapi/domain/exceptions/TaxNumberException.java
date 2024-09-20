package br.api.walletapi.domain.exceptions;

public class TaxNumberException extends Exception {
    // Attribute
    private String code;

    // Builder
    public TaxNumberException(String message, String code) {
        super(message);
        this.code = code;
    }

}
