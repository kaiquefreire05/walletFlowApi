package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.CreateTransactionPinGateway;
import br.api.walletapi.domain.entities.TransactionPin;
import br.api.walletapi.usecases.CreateTransactionalPinUseCase;

public class CreateTransactionPinImpl implements CreateTransactionalPinUseCase {
    // Dependencies Injection
    private CreateTransactionPinGateway _gateway;

    public CreateTransactionPinImpl(CreateTransactionPinGateway gateway) {
        _gateway = gateway;
    }

    // Method
    @Override
    public void create(TransactionPin transactionPin) {
        _gateway.create(transactionPin);
    }
}
