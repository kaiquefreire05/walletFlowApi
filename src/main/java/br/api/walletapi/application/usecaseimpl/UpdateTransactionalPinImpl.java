package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.UpdateTransactionPinGateway;
import br.api.walletapi.domain.entities.TransactionPin;
import br.api.walletapi.usecases.UpdateTransactionalPinUseCase;

public class UpdateTransactionalPinImpl implements UpdateTransactionalPinUseCase {
    // Dependencies Injection
    private UpdateTransactionPinGateway _updateTransactionPinGateway;

    public UpdateTransactionalPinImpl(UpdateTransactionPinGateway updateTransactionPinGateway) {
        _updateTransactionPinGateway = updateTransactionPinGateway;
    }

    // Method
    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        return _updateTransactionPinGateway.update(transactionPin);
    }
}
