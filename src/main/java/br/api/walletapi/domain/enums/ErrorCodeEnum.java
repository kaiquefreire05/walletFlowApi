package br.api.walletapi.domain.enums;

public enum ErrorCodeEnum {

    ON0001("Tax Number invalid", "ON-0001"),
    ON0002("Tax Number unavailable", "ON-0002"),
    ON0003("Email unavailable", "ON-0003"),
    TR0001("Store user does not have the transfer function available", "TR-0001"),
    TR0002("Balance unavailable", "TR-0002"),
    TRP0001("Pin invalid", "TRP-0001")

    ;

    // Attributes

    private String message;
    private String code;

    // Builder

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    // Getters and Setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
