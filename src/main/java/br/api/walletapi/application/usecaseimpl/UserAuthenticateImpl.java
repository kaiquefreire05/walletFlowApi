package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.UserAuthenticateGateway;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.AuthenticateException;
import br.api.walletapi.usecases.UserAuthenticateUseCase;

public class UserAuthenticateImpl implements UserAuthenticateUseCase {
    // Dependencies Injection
    private UserAuthenticateGateway _userAuthenticateGateway;

    public UserAuthenticateImpl(UserAuthenticateGateway userAuthenticateGateway) {
        _userAuthenticateGateway = userAuthenticateGateway;
    }

    // Method
    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {
        if (!_userAuthenticateGateway.authenticate(username, password)) {
            throw new AuthenticateException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
        }
        return true;
    }
}
