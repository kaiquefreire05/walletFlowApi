package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.CreateUserGateway;
import br.api.walletapi.domain.entities.TransactionPin;
import br.api.walletapi.domain.entities.User;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.EmailException;
import br.api.walletapi.domain.exceptions.InternalServerErrorException;
import br.api.walletapi.domain.exceptions.TaxNumberException;
import br.api.walletapi.domain.exceptions.TransactionPinException;
import br.api.walletapi.usecases.*;

import java.math.BigDecimal;

public class CreateUserImpl implements CreateUserUseCase {
    // Dependencies Injection
    private final TaxNumberAvailableUseCase _taxNumberAvailableUseCase;
    private final EmailAvailableUseCase _emailAvailableUseCase;
    private final CreateUserGateway _createUserGateway;

    public CreateUserImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase
            , EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        _taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        _emailAvailableUseCase = emailAvailableUseCase;
        _createUserGateway = createUserGateway;
    }

    // Method
    @Override
    public void Create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException
            , InternalServerErrorException {

        if (!_taxNumberAvailableUseCase.isTaxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!_emailAvailableUseCase.emailAvailable(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        boolean success = _createUserGateway.create(user, new Wallet(new TransactionPin(pin), BigDecimal.ZERO, user));
        if (!success) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }

    }
}
