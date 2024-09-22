package br.api.walletapi.application.gateway;

import br.api.walletapi.domain.entities.TransactionPin;

public interface TransactionPinValidationGateway {
    boolean validate(TransactionPin transactionPin);
}
