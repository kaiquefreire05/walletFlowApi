package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.FindWalletByTaxNumberGateway;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.NotFoundException;
import br.api.walletapi.usecases.FindWalletByTextNumberUseCase;

public class FindWalletByTaxNumberImpl implements FindWalletByTextNumberUseCase {
    // Dependencies Injection
    private final FindWalletByTaxNumberGateway _findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        _findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    // Method
    @Override
    public Wallet findByTaxNumber(String taxNumber) throws NotFoundException {
        var wallet =  _findWalletByTaxNumberGateway.getWalletByTaxNumber(taxNumber);
        if (wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        return wallet;
    }
}
