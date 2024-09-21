package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.EmailAvailableGateway;
import br.api.walletapi.usecases.EmailAvailableUseCase;

public class EmailAvailableImpl implements EmailAvailableUseCase {
    // Dependencies Injection
    private EmailAvailableGateway _emailAvailableGateway;

    public EmailAvailableImpl(EmailAvailableGateway emailAvailableGateway) {
        _emailAvailableGateway = emailAvailableGateway;
    }

    // Method
    @Override
    public Boolean emailAvailable(String email) {
        return _emailAvailableGateway.isAvailable(email);
    }
}
