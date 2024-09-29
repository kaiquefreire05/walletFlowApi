package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.TaxNumberAvailableGateway;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.TaxNumberException;
import br.api.walletapi.usecases.TaxNumberAvailableUseCase;

public class TaxNumberAvailableImpl implements TaxNumberAvailableUseCase {
    // Dependencies Injection
    private TaxNumberAvailableGateway _taxNumberAvailableGateway;

    public TaxNumberAvailableImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        _taxNumberAvailableGateway = taxNumberAvailableGateway;
    }
    @Override
    public Boolean isTaxNumberAvailable(String taxNumber) throws TaxNumberException {

        if (!_taxNumberAvailableGateway.isTaxNumberAvailable(taxNumber)) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        return true;
    }
}
