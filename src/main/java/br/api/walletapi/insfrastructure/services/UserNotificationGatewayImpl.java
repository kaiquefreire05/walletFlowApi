package br.api.walletapi.insfrastructure.services;

import br.api.walletapi.application.gateway.UserNotificationGateway;
import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.insfrastructure.client.usernotificate.NotificationService;
import org.springframework.stereotype.Service;
import static br.api.walletapi.insfrastructure.utils.Utilies.log;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {
    private final NotificationService _notificationService;

    public UserNotificationGatewayImpl(NotificationService notificationService) {
        _notificationService = notificationService;
    }

    // Method
    @Override
    public Boolean notify(Transaction transaction, String email) {
        var response = _notificationService.notification();
        if (response) {
            log.info("User notification with success::UserNotificationGatewayImpl");
            return true;
        }
        return response;
    }
}
