package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.domain.exceptions.NotFoundException;
import br.api.walletapi.usecases.ConsultBalanceUseCase;
import br.api.walletapi.usecases.FindWalletByTaxNumberUseCase;

import java.math.BigDecimal;

public class ConsultBalanceImpl implements ConsultBalanceUseCase {
    // Dependencies Injection
    private FindWalletByTaxNumberUseCase _findWalletByTaxNumberUseCase;

    public ConsultBalanceImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        _findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
    }

    // Methods
    @Override
    public BigDecimal consultBalance(String taxNumber) throws Exception {
        var walletFound = _findWalletByTaxNumberUseCase.findByTaxNumber(taxNumber);
        return walletFound.getBalance();
    }
}
