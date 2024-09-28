package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.CreateTransactionalGateway;
import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.TransferException;
import br.api.walletapi.usecases.CreateTransactionalUseCase;

public class CreateTransactionalImpl implements CreateTransactionalUseCase {
    // Dependencies Injection
    private CreateTransactionalGateway _createTransactionalGateway;
    public CreateTransactionalImpl(CreateTransactionalGateway createTransactionalGateway) {
        _createTransactionalGateway = createTransactionalGateway;
    }

    // Method
    @Override
    public Transaction create(Transaction transaction) throws Exception {
        var newTransaction = _createTransactionalGateway.createTransaction(transaction);
        if (newTransaction == null) {
            throw new TransferException(ErrorCodeEnum.TR0003.getCode(), ErrorCodeEnum.TR0003.getMessage());
        }
        return newTransaction;
    }
}
