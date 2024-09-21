package br.api.walletapi.application.gateway;

public interface EmailAvailableGateway {
    Boolean isAvailable(String email);
}
