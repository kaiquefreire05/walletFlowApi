package br.api.walletapi.usecases.interfaces;

import br.api.walletapi.domain.entities.Transaction;

public interface UserNotificationUseCase {
    Boolean notification(Transaction transaction, String email);
}
