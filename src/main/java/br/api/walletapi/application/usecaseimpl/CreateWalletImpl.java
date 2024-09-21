package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.CreateWalletGateway;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.usecases.CreateWalletUseCase;

public class CreateWalletImpl implements CreateWalletUseCase {
    // Dependencies Injection
    private CreateWalletGateway _createWalletGateway;

    public CreateWalletImpl(CreateWalletGateway createWalletGateway) {
        _createWalletGateway = createWalletGateway;
    }
    
    // Method
    @Override
    public void createWallet(Wallet wallet) {
        _createWalletGateway.create(wallet);
    }
}
