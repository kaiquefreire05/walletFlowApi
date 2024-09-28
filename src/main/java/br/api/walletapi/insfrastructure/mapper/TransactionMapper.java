package br.api.walletapi.insfrastructure.mapper;

import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.domain.enums.TransactionStatusEnum;
import br.api.walletapi.insfrastructure.entities.TransactionEntity;
import br.api.walletapi.insfrastructure.entities.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    // Dependencies Injection
    private WalletMapper _walletMapper;

    public TransactionMapper(WalletMapper walletMapper) {
        _walletMapper = walletMapper;
    }

    // Method
    public TransactionEntity createTransaction(Transaction transaction) {
        return new TransactionEntity(
            transaction.getUpdatedAt(),
            transaction.getCreatedAt(),
            TransactionStatusEnum.CREATED,
            transaction.getValue(),
            _walletMapper.toWalletEntity(transaction.getFromWallet()),
            _walletMapper.toWalletEntity(transaction.getToWallet())
        );
    }

    public Transaction toTransaction(TransactionEntity transactionEntity) throws Exception {
        return new Transaction(
              transactionEntity.getId(),
              _walletMapper.toWallet(transactionEntity.getFromWallet()),
              _walletMapper.toWallet(transactionEntity.getToWallet()),
              transactionEntity.getValue(),
              transactionEntity.getStatus(),
              transactionEntity.getCreatedAt(),
              transactionEntity.getUpdatedAt()
        );
    }

    public TransactionEntity concludeTransaction(Transaction transaction) {
        return new TransactionEntity(
            transaction.getId(),
            _walletMapper.toWalletEntity(transaction.getFromWallet()),
            _walletMapper.toWalletEntity(transaction.getToWallet()),
            transaction.getValue(),
            TransactionStatusEnum.SUCCESS,
            transaction.getUpdatedAt(),
            transaction.getCreatedAt()
        );
    }

    public TransactionEntity cancelTransaction(Transaction transaction) {
        return new TransactionEntity(
            transaction.getId(),
            _walletMapper.toWalletEntity(transaction.getFromWallet()),
            _walletMapper.toWalletEntity(transaction.getToWallet()),
            transaction.getValue(),
            TransactionStatusEnum.CANCELED,
            transaction.getUpdatedAt(),
            transaction.getCreatedAt()
        );
    }
}
