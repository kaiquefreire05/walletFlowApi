package br.api.walletapi.insfrastructure.services;

import br.api.walletapi.application.gateway.UpdateTransactionPinGateway;
import br.api.walletapi.domain.entities.TransactionPin;
import br.api.walletapi.insfrastructure.mapper.TransactionPinMapper;
import br.api.walletapi.insfrastructure.repositories.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTransactionPinGatewayImpl implements UpdateTransactionPinGateway {
    // Dependencies Injection
    private TransactionPinEntityRepository _transactionPinEntityRepository;
    private TransactionPinMapper _transactionPinMapper;

    public UpdateTransactionPinGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper) {
        _transactionPinEntityRepository = transactionPinEntityRepository;
        _transactionPinMapper = transactionPinMapper;
    }

    // Method
    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        return _transactionPinMapper.toTransactionPin(_transactionPinEntityRepository
                .save(_transactionPinMapper.toTransactionPinEntityUpdate(transactionPin)));
    }
}
