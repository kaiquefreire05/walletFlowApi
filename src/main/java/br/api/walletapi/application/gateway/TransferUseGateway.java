package br.api.walletapi.application.gateway;

import br.api.walletapi.domain.entities.Transaction;

public interface TransferUseGateway {
    Boolean transfer(Transaction transaction);
}
