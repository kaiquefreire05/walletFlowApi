package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.TransactionPin;
import br.api.walletapi.domain.exceptions.PinException;
import br.api.walletapi.domain.exceptions.TransferException;

public interface TransactionPinValidationUseCase {
    Boolean validate(TransactionPin transactionPin) throws TransferException, PinException;
}
