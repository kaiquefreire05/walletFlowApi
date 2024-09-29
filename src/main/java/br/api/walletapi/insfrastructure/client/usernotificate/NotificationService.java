package br.api.walletapi.insfrastructure.client.usernotificate;

import org.springframework.stereotype.Service;

@Service
public class NotificationService{
    // Dependencies Injection
    private final NotificationClient _notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        _notificationClient = notificationClient;
    }

    // Method
    public Boolean notification() {
        var response = _notificationClient.notification();
        return response.success();
    }
}
