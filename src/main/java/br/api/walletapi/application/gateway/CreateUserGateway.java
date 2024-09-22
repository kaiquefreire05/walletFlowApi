package br.api.walletapi.application.gateway;

import br.api.walletapi.domain.entities.User;
import br.api.walletapi.domain.entities.Wallet;

public interface CreateUserGateway {
    Boolean create(User user, Wallet wallet);
}
