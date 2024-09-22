package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.domain.exceptions.TransferException;

public interface CreateTransactionalUseCase {
    Transaction create(Transaction transaction) throws TransferException;
}
