package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.CreateTransactionalGateway;
import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.TransferException;
import br.api.walletapi.usecases.CreateTransactionalUseCase;

import java.math.BigDecimal;

public class CreateTransactionalImpl implements CreateTransactionalUseCase {
    // Dependencies Injection
    private CreateTransactionalGateway _createTransactionalGateway;
    public CreateTransactionalImpl(CreateTransactionalGateway createTransactionalGateway) {
        _createTransactionalGateway = createTransactionalGateway;
    }

    // Method
    @Override
    public Transaction create(Wallet to, Wallet from, BigDecimal value) throws Exception {
        var transaction = new Transaction(to, from, value);
        var transactionSaved = _createTransactionalGateway.createTransaction(transaction);

        if (transactionSaved == null) {
            throw new TransferException(ErrorCodeEnum.TR0003.getCode(), ErrorCodeEnum.TR0003.getMessage());
        }
        return transactionSaved;
    }
}
