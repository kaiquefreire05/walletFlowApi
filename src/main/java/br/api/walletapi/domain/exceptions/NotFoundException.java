package br.api.walletapi.domain.exceptions;

public class NotFoundException extends Exception {
    // Attribute
    private String code;

    // Builder
    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }

    // Getter
    public String getCode() {
        return code;
    }

}
