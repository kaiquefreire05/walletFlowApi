package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.domain.entities.Wallet;

import java.math.BigDecimal;

public interface CreateTransactionalUseCase {
    Transaction create(Wallet to, Wallet from, BigDecimal value) throws Exception;
}
