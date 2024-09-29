package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.TransactionPinValidationGateway;
import br.api.walletapi.domain.entities.TransactionPin;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.PinException;
import br.api.walletapi.domain.exceptions.TransferException;
import br.api.walletapi.usecases.TransactionPinValidationUseCase;
import br.api.walletapi.usecases.UpdateTransactionalPinUseCase;

public class TransactionPinValidationImpl implements TransactionPinValidationUseCase {
    // Dependencies Injection
    private final TransactionPinValidationGateway _transactionPinValidationGateway;
    private final UpdateTransactionalPinUseCase _updateTransactionalPinUseCase;

    public TransactionPinValidationImpl(TransactionPinValidationGateway transactionPinValidationGateway
            , UpdateTransactionalPinUseCase updateTransactionalPinUseCase) {
        _transactionPinValidationGateway = transactionPinValidationGateway;
        _updateTransactionalPinUseCase = updateTransactionalPinUseCase;
    }

    // Method
    @Override
    public Boolean validate(TransactionPin transactionPin, String pin) throws PinException {

        if (transactionPin.getBlocked()) {
            throw new PinException(ErrorCodeEnum.PIN0001.getCode(), ErrorCodeEnum.PIN0001.getMessage());
        }

        if (!_transactionPinValidationGateway.validate(transactionPin, pin)) {
            transactionPin.setAttempt();
            var transactionPinUpdated = _updateTransactionalPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.pin0002GetMessage(transactionPinUpdated.getAttempt())
                    , ErrorCodeEnum.PIN0002.getCode());
        }

        if (transactionPin.getAttempt() < 3) {
            transactionPin.restaureAttempt();
            _updateTransactionalPinUseCase.update(transactionPin);
        }
        return true;
    }
}
