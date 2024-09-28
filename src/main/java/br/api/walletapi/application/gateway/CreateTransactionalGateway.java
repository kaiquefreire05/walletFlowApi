package br.api.walletapi.application.gateway;

import br.api.walletapi.domain.entities.Transaction;

public interface CreateTransactionalGateway {
    Transaction createTransaction(Transaction transaction) throws Exception;
}
