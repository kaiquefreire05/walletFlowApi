package br.api.walletapi.application.gateway;

import br.api.walletapi.domain.entities.Wallet;

public interface CreateWalletGateway {
    void create(Wallet wallet);
}
