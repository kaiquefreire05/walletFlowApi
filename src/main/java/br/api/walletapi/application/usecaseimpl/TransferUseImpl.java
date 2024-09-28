package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.TransferUseGateway;
import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.*;
import br.api.walletapi.usecases.*;

import java.math.BigDecimal;

public class TransferUseImpl implements TransferUseCase {
    // Dependencies Injection
    private FindWalletByTaxNumberUseCase _findWalletByTaxNumberUseCase;
    private TransactionValidationUseCase _transactionValidationUseCase;
    private CreateTransactionalUseCase _createTransactionalUseCase;
    private TransferUseGateway _transferGateway;
    private UserNotificationUseCase _userNotificationUseCase;
    private TransactionPinValidationUseCase _transactionPinValidationUseCase;

    public TransferUseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase
            , TransactionValidationUseCase transactionValidationUseCase
            , CreateTransactionalUseCase createTransactionalUseCase, TransferUseGateway transferGateway
            , UserNotificationUseCase userNotificationUseCase, TransactionPinValidationUseCase transactionPinValidationUseCase) {
        _findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        _transactionValidationUseCase = transactionValidationUseCase;
        _createTransactionalUseCase = createTransactionalUseCase;
        _transferGateway = transferGateway;
        _userNotificationUseCase = userNotificationUseCase;
        _transactionPinValidationUseCase = transactionPinValidationUseCase;
    }

    // Method
    @Override
    public Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value, String pin)
            throws Exception {

        Wallet from = _findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = _findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        from.transfer(value);
        to.receiveValue(value);

        _transactionPinValidationUseCase.validate(from.getTransactionPin());

        var transaction = _createTransactionalUseCase.create(new Transaction(from, to, value));
        _transactionValidationUseCase.validate(transaction);

        if (!_transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if (!_userNotificationUseCase.notification(transaction, to.getUser().getEmail())) {
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }
        return true;
    }
}
