package br.api.walletapi.insfrastructure.dto.requests;

import java.math.BigDecimal;

public record TransferRequest(String toTaxNumber, String fromTaxNumber, BigDecimal value, String pin) {
}
