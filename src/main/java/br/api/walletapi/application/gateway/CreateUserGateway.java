package br.api.walletapi.application.gateway;

import br.api.walletapi.domain.entities.User;

public interface CreateUserGateway {
    User create(User user);
}
