package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.TaxNumberAvailableGateway;
import br.api.walletapi.usecases.TaxNumberAvailableUseCase;

public class TaxNumberAvailableImpl implements TaxNumberAvailableUseCase {
    // Dependencies Injection
    private TaxNumberAvailableGateway _taxNumberAvailableGateway;

    public TaxNumberAvailableImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        _taxNumberAvailableGateway = taxNumberAvailableGateway;
    }
    @Override
    public Boolean isTaxNumberAvailable(String taxNumber) {
        return _taxNumberAvailableGateway.isTaxNumberAvailable(taxNumber);
    }
}
