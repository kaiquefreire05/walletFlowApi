package br.api.walletapi.usecases.interfaces;

import br.api.walletapi.domain.entities.Transaction;

public interface CreateTransactionalUseCase {
    void create(Transaction transaction);
}
