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

    private final CreateUserGateway _createUserGateway;

    public CreateUserImpl(CreateUserGateway createUserGateway) {
        _createUserGateway = createUserGateway;
    }

    // Method
    @Override
    public void Create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException
            , InternalServerErrorException {

        boolean success = _createUserGateway.create(user, new Wallet(new TransactionPin(pin), BigDecimal.ZERO, user));
        if (!success) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}
