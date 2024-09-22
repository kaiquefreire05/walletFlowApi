package br.api.walletapi.application.gateway;

import br.api.walletapi.domain.entities.Transaction;

public interface UserNotificationGateway {
    Boolean notify(Transaction transaction, String email);
}
