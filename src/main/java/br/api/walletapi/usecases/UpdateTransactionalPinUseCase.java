package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.TransactionPin;
import br.api.walletapi.domain.exceptions.TransferException;

public interface UpdateTransactionalPinUseCase {
    TransactionPin update(TransactionPin transactionPin);
}
