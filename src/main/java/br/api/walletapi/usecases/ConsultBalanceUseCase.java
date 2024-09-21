package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consultBalance(Wallet wallet);
}
