package br.api.walletapi.usecases;

import br.api.walletapi.domain.exceptions.AuthenticateException;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password) throws AuthenticateException;
}
