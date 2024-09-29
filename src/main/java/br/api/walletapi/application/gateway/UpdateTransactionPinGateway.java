package br.api.walletapi.application.gateway;

import br.api.walletapi.domain.entities.TransactionPin;

public interface UpdateTransactionPinGateway {
    TransactionPin update(TransactionPin transactionPin);
}
