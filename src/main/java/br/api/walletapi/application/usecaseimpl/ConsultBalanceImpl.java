package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.ConsultBalanceGateway;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.usecases.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceImpl implements ConsultBalanceUseCase {
    // Dependencies Injection
    private final ConsultBalanceGateway _consultBalanceGateway;

    public ConsultBalanceImpl(ConsultBalanceGateway consultBalanceGateway) {
        _consultBalanceGateway = consultBalanceGateway;
    }

    // Methods
    @Override
    public BigDecimal consultBalance(Wallet wallet) {
        return _consultBalanceGateway.consultBalance(wallet);
    }
}
