package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.UserNotificationGateway;
import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.usecases.UserNotificationUseCase;

public class UserNotificationImpl implements UserNotificationUseCase {
    // Dependencies Injection
    private UserNotificationGateway _userNotificationGateway;

    public UserNotificationImpl(UserNotificationGateway userNotificationGateway) {
        _userNotificationGateway = userNotificationGateway;
    }

    // Method
    @Override
    public Boolean notification(Transaction transaction, String email) {
        return _userNotificationGateway.notify(transaction, email);
    }
}
