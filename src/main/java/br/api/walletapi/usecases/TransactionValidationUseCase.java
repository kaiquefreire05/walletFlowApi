package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.Transaction;

public interface TransactionValidationUseCase {
    Boolean validateTransaction(Transaction transaction);
}