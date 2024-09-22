package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.TaxNumber;
import br.api.walletapi.domain.entities.User;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.domain.exceptions.NotFoundException;

public interface FindWalletByTextNumberUseCase {
    Wallet findByTaxNumber(String taxNumber) throws NotFoundException;
}
