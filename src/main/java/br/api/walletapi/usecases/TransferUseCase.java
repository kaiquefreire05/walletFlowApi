package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.Transaction;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction);
}
