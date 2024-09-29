package br.api.walletapi.application.usecaseimpl;

import br.api.walletapi.application.gateway.TransferUseGateway;
import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.domain.entities.User;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.*;
import br.api.walletapi.usecases.*;

import java.math.BigDecimal;

public class TransferUseImpl implements TransferUseCase {
    // Dependencies Injection
    private final TransferUseGateway _transferGateway;

    public TransferUseImpl(TransferUseGateway transferGateway) {
        _transferGateway = transferGateway;
    }

    // Method
    @Override
    public Boolean transfer(Transaction transaction) throws Exception {

        transaction.getFromWallet().transfer(transaction.getValue());
        transaction.getToWallet().receiveTransfer(transaction.getValue());

        if (!_transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }
        return true;
    }
}
