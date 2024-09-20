package br.api.walletapi.usecases.interfaces;

import br.api.walletapi.domain.entities.TransactionPin;

public interface CreateTransactionalPinUseCase {
    void create(TransactionPin transactionPin);
}
