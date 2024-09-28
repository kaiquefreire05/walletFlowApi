package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.FindWalletByTaxNumberGateway;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.NotFoundException;
import br.api.walletapi.usecases.FindWalletByTaxNumberUseCase;
import org.springframework.stereotype.Service;

public class FindWalletByTaxNumberImpl implements FindWalletByTaxNumberUseCase {
    // Dependencies Injection
    private FindWalletByTaxNumberGateway _findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        _findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    // Method
    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        var wallet =  _findWalletByTaxNumberGateway.findWalletByTaxNumber(taxNumber);
        if (wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        return wallet;
    }
}
