package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.TransactionPin;

public interface CreateTransactionalPinUseCase {
    void create(TransactionPin transactionPin);
}
