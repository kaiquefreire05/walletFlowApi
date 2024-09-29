package br.api.walletapi.insfrastructure.services;

import br.api.walletapi.application.gateway.CreateTransactionalGateway;
import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.insfrastructure.mapper.TransactionMapper;
import br.api.walletapi.insfrastructure.repositories.TransactionEntityRepository;
import org.springframework.stereotype.Service;
import static br.api.walletapi.insfrastructure.utils.Utilies.log;

@Service
public class CreateTransactionalGatewayImpl implements CreateTransactionalGateway {
    // Dependencies Injection
    private TransactionEntityRepository _transactionEntityRepository;
    private TransactionMapper _transactionMapper;

    public CreateTransactionalGatewayImpl(TransactionEntityRepository transactionEntityRepository
            , TransactionMapper transactionMapper) {
        _transactionEntityRepository = transactionEntityRepository;
        _transactionMapper = transactionMapper;
    }

    // Method
    @Override
    public Transaction createTransaction(Transaction transaction) {
        try {
            log.info("Start of transaction creation::CreateTransactionGatewayImpl");
            var transactionEntity = _transactionMapper.createTransaction(transaction);
            return _transactionMapper.toTransaction(_transactionEntityRepository.save(transactionEntity));

        } catch (Exception ex) {
            return null;
        }
    }
}
