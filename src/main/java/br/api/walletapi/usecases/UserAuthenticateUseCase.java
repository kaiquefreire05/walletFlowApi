package br.api.walletapi.usecases;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password);
}
