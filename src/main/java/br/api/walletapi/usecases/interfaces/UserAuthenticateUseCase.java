package br.api.walletapi.usecases.interfaces;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password);
}
