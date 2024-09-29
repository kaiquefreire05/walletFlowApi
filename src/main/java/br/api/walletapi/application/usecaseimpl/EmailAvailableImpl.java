package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.EmailAvailableGateway;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.EmailException;
import br.api.walletapi.usecases.EmailAvailableUseCase;

public class EmailAvailableImpl implements EmailAvailableUseCase {
    // Dependencies Injection
    private EmailAvailableGateway _emailAvailableGateway;

    public EmailAvailableImpl(EmailAvailableGateway emailAvailableGateway) {
        _emailAvailableGateway = emailAvailableGateway;
    }

    // Method
    @Override
    public Boolean emailAvailable(String email) throws EmailException {

        if (!_emailAvailableGateway.isAvailable(email)) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }
        return true;
    }
}
