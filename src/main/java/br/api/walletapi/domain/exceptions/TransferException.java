package br.api.walletapi.domain.exceptions;

public class TransferException extends Exception {
    // Attribute
    private String code;

    // Builder
    public TransferException(String code, String message) {
        super(message);
        this.code = code;
    }

    // Getter
    public String getCode() {
        return code;
    }

}
