package br.api.walletapi.insfrastructure.services;

import br.api.walletapi.application.gateway.UserNotificationGateway;
import br.api.walletapi.domain.entities.Transaction;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {
    @Override
    public Boolean notify(Transaction transaction, String email) {
        //TODO: Implement method
        return true;
    }
}
