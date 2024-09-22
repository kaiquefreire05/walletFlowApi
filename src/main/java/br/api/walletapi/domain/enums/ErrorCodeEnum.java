package br.api.walletapi.domain.enums;

public enum ErrorCodeEnum {

    ON0001("Tax Number invalid", "ON-0001"),
    ON0002("Tax Number unavailable", "ON-0002"),
    ON0003("Email unavailable", "ON-0003"),
    ON0004("There was an error creating the user", "ON-0004"),

    TR0001("Store user does not have the transfer function available", "TR-0001"),
    TR0002("Balance unavailable", "TR-0002"),
    TR0003("There was an error performing the transfer", "TR-0003"),
    TR0004("Unauthorized transfer", "TR-0004"),

    TRP0001("Pin invalid", "TRP-0001"),

    WA0001("Wallet not found", "WA-0001"),

    NO0001("There was an error in user notification", "NO-0001"),

    ATH0001("There was an error in authentication", "ATH-0001"),

    PIN0001("Transaction PIN blocked", "PIN-0001"),
    PIN0002("Incorrect PIN, %d attempt(s) remaining:", "PIN-0002"),
    ;

    // Attributes
    private String message;
    private String code;

    // Builder
    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    // Method
    public static String pin0002GetMessage(Integer attempt) {
        return String.format(PIN0002.message, attempt);
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
