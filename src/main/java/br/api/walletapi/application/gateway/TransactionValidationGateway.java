package br.api.walletapi.application.gateway;

import br.api.walletapi.domain.entities.Transaction;

public interface TransactionValidationGateway {
    Boolean validateTransaction(Transaction transaction);
}
