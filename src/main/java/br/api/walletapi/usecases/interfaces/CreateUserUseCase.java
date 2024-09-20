package br.api.walletapi.usecases.interfaces;

import br.api.walletapi.domain.entities.User;

public interface CreateUserUseCase {
    void Create(User user);
}
