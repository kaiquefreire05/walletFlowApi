package br.api.walletapi.insfrastructure.mapper;

import br.api.walletapi.domain.entities.TransactionPin;
import br.api.walletapi.insfrastructure.entities.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {
    // Methods
    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin) {
        return new TransactionPinEntity(
                transactionPin.getPin(),
                transactionPin.getBlocked(),
                transactionPin.getAttempt(),
                transactionPin.getCreatedAt(),
                transactionPin.getUpdateAt()
        );
    }
}