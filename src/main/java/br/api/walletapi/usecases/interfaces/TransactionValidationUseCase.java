package br.api.walletapi.usecases.interfaces;

import br.api.walletapi.domain.entities.Transaction;

public interface TransactionValidationUseCase {
    Boolean validateTransaction(Transaction transaction);
}
