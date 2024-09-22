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
    private final FindWalletByTextNumberUseCase _findWalletByTextNumberUseCase;
    private final TransactionValidationUseCase _transactionValidationUseCase;
    private final CreateTransactionalUseCase _createTransactionalUseCase;
    private final TransferUseGateway _transferGateway;
    private final UserNotificationUseCase _userNotificationUseCase;
    private final TransactionPinValidationUseCase _transactionPinValidationUseCase;

    public TransferUseImpl(FindWalletByTextNumberUseCase findWalletByTextNumberUseCase
            , TransactionValidationUseCase transactionValidationUseCase
            , CreateTransactionalUseCase createTransactionalUseCase, TransferUseGateway transferGateway
            , UserNotificationUseCase userNotificationUseCase, TransactionPinValidationUseCase transactionPinValidationUseCase) {
        _findWalletByTextNumberUseCase = findWalletByTextNumberUseCase;
        _transactionValidationUseCase = transactionValidationUseCase;
        _createTransactionalUseCase = createTransactionalUseCase;
        _transferGateway = transferGateway;
        _userNotificationUseCase = userNotificationUseCase;
        _transactionPinValidationUseCase = transactionPinValidationUseCase;
    }

    // Method
    @Override
    public Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value, String pin)
            throws InternalServerErrorException, TransferException, NotFoundException, NotificationException, PinException {

        Wallet from = _findWalletByTextNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = _findWalletByTextNumberUseCase.findByTaxNumber(toTaxNumber);

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
