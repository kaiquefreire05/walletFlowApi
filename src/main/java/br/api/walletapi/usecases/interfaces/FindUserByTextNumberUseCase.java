package br.api.walletapi.usecases.interfaces;

import br.api.walletapi.domain.entities.TaxNumber;
import br.api.walletapi.domain.entities.User;

public interface FindUserByTextNumberUseCase {
    User findByTaxNumber(TaxNumber taxNumber);
}
