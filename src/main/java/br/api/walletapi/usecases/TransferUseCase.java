package br.api.walletapi.usecases;

import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.domain.exceptions.*;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value, String pin)
            throws Exception;
}
