package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.Transaction;

public interface UserNotificationUseCase {
    Boolean notification(Transaction transaction, String email);
}
