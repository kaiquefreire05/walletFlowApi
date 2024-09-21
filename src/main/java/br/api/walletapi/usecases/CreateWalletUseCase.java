package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.Wallet;

public interface CreateWalletUseCase {
    void createWallet(Wallet wallet);
}
