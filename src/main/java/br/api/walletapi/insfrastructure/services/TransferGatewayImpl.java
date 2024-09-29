package br.api.walletapi.insfrastructure.services;

import br.api.walletapi.application.gateway.TransferUseGateway;
import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.insfrastructure.entities.TransactionEntity;
import br.api.walletapi.insfrastructure.mapper.TransactionMapper;
import br.api.walletapi.insfrastructure.mapper.WalletMapper;
import br.api.walletapi.insfrastructure.repositories.TransactionEntityRepository;
import br.api.walletapi.insfrastructure.repositories.WalletEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferGatewayImpl implements TransferUseGateway {
    // Dependencies Injection
    private WalletEntityRepository _walletEntityRepository;
    private WalletMapper _walletMapper;
    private TransactionEntityRepository _transactionEntityRepository;
    private TransactionMapper _transactionMapper;

    public TransferGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper, TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        _walletEntityRepository = walletEntityRepository;
        _walletMapper = walletMapper;
        _transactionEntityRepository = transactionEntityRepository;
        _transactionMapper = transactionMapper;
    }


    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
        try {
            _walletEntityRepository.save(_walletMapper.toWalletEntityUpdate(transaction.getFromWallet()));
            _walletEntityRepository.save(_walletMapper.toWalletEntityUpdate(transaction.getToWallet()));
            _transactionEntityRepository.save(_transactionMapper.concludeTransaction(transaction));
            return true;

        } catch (Exception ex) {
            _transactionEntityRepository.save(_transactionMapper.cancelTransaction(transaction));
            return null;
        }
    }
}
