package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.domain.exceptions.NotFoundException;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consultBalance(String taxNumber) throws Exception;
}
