package br.api.walletapi.domain.exceptions;

public class EmailException extends Exception {
    // Attribute
    private String code;

    // Builder
    public EmailException(String message, String code) {
        super(message);
        this.code = code;
    }

    // Getter
    public String getCode() {
        return code;
    }

}
