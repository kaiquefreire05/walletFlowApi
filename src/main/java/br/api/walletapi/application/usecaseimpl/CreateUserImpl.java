package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.CreateUserGateway;
import br.api.walletapi.domain.entities.TransactionPin;
import br.api.walletapi.domain.entities.User;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.EmailException;
import br.api.walletapi.domain.exceptions.TaxNumberException;
import br.api.walletapi.domain.exceptions.TransactionPinException;
import br.api.walletapi.usecases.*;

import java.math.BigDecimal;

public class CreateUserImpl implements CreateUserUseCase {
    // Dependencies Injection
    private TaxNumberAvailableUseCase _taxNumberAvailableUseCase;
    private EmailAvailableUseCase _emailAvailableUseCase;
    private CreateUserGateway _createUserGateway;
    private CreateTransactionalPinUseCase _createTransactionalPinUseCase;
    private CreateWalletUseCase _createWalletUseCase;

    public CreateUserImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase
            , EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway
            , CreateTransactionalPinUseCase createTransactionalPinUseCase, CreateWalletUseCase createWalletUseCase) {
        _taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        _emailAvailableUseCase = emailAvailableUseCase;
        _createUserGateway = createUserGateway;
        _createTransactionalPinUseCase = createTransactionalPinUseCase;
        _createWalletUseCase = createWalletUseCase;
    }

    // Method
    @Override
    public void Create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException {

        if (!_taxNumberAvailableUseCase.isTaxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!_emailAvailableUseCase.emailAvailable(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        var userSaved = _createUserGateway.create(user);
        _createWalletUseCase.createWallet(new Wallet(BigDecimal.ZERO, userSaved));
        _createTransactionalPinUseCase.create(new TransactionPin(userSaved, pin));
    }
}
