package br.api.walletapi.application.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String username, String password);
}
