package br.api.walletapi.insfrastructure.dto.response;

public record ValidationError(String field, String message) {
}
