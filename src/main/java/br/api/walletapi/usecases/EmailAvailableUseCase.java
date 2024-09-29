package br.api.walletapi.usecases;

import br.api.walletapi.domain.exceptions.EmailException;

public interface EmailAvailableUseCase {
    Boolean emailAvailable(String email) throws EmailException;
}
