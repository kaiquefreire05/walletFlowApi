package br.api.walletapi.insfrastructure.dto.response;

import java.util.List;

public record ErrorResponse(String message, String code, List<ValidationError> validations) {

}
