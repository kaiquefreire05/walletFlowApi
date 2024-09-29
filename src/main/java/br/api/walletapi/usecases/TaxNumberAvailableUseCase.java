package br.api.walletapi.usecases;

import br.api.walletapi.domain.exceptions.TaxNumberException;

public interface TaxNumberAvailableUseCase {
    Boolean isTaxNumberAvailable(String taxNumber) throws TaxNumberException;
}
