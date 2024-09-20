package br.api.walletapi.domain.exceptions;

public class TransactionPinException extends Exception {
    // Attribute
    private String code;

    // Builder
    public TransactionPinException(String message, String code) {
        super(message);
        this.code = code;
    }

}
