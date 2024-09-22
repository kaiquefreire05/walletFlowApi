package br.api.walletapi.application.gateway;

import br.api.walletapi.domain.entities.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet getWalletByTaxNumber(String taxNumber);
}
