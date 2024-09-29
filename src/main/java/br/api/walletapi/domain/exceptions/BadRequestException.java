package br.api.walletapi.domain.exceptions;

public class BadRequestException extends Exception {
    // Attribute
    private String code;

    // Builder
    public BadRequestException(String message, String code) {
        super(message);
        this.code = code;
    }

    // Getter
    public String getCode() {
        return code;
    }

}
