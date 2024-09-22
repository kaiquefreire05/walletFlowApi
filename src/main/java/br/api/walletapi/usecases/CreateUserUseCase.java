package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.User;
import br.api.walletapi.domain.exceptions.EmailException;
import br.api.walletapi.domain.exceptions.InternalServerErrorException;
import br.api.walletapi.domain.exceptions.TaxNumberException;
import br.api.walletapi.domain.exceptions.TransactionPinException;

public interface CreateUserUseCase {
    void Create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException;
}
