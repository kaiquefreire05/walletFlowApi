package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.TransactionValidationGateway;
import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.TransferException;
import br.api.walletapi.usecases.TransactionValidationUseCase;

public class TransactionValidationImpl implements TransactionValidationUseCase {
    // Dependencies Injection
    private final TransactionValidationGateway _transactionValidationGateway;

    public TransactionValidationImpl(TransactionValidationGateway transactionValidationGateway) {
        _transactionValidationGateway = transactionValidationGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        if (!_transactionValidationGateway.validateTransaction(transaction)) {
            throw new TransferException(ErrorCodeEnum.TR0004.getCode(), ErrorCodeEnum.TR0004.getMessage());
        }
        return true;
    }
}
