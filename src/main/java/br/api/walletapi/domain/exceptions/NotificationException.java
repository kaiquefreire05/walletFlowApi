package br.api.walletapi.domain.exceptions;

public class NotificationException extends Exception {
    // Attribute
    private String code;

    // Builder
    public NotificationException(String message, String code) {
        super(message);
        this.code = code;
    }

    // Getter
    public String getCode() {
        return code;
    }

}
