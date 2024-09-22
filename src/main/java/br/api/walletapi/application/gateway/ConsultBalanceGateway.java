package br.api.walletapi.application.gateway;

import br.api.walletapi.domain.entities.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {
    BigDecimal consultBalance(Wallet wallet);
}
