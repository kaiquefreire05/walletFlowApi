package br.api.walletapi.insfrastructure.mapper;

import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.insfrastructure.entities.TransactionPinEntity;
import br.api.walletapi.insfrastructure.entities.UserEntity;
import br.api.walletapi.insfrastructure.entities.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
    // Dependencies Injection
    private TransactionPinMapper _transactionPinMapper;
    private UserMapper _userMapper;

    public WalletMapper(TransactionPinMapper transactionPinMapper, UserMapper userMapper) {
        _transactionPinMapper = transactionPinMapper;
        _userMapper = userMapper;
    }

    // Method
    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        return new WalletEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

    public WalletEntity toWalletEntity(Wallet wallet) {
        return new WalletEntity(
                wallet.getBalance(),
                _userMapper.toUserEntity(wallet.getUser()),
                _transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()),
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

    public WalletEntity toWalletEntityUpdate(Wallet wallet) {
        return new WalletEntity(
                wallet.getId(),
                wallet.getBalance(),
                _userMapper.toUserEntity(wallet.getUser()),
                _transactionPinMapper.toTransactionPinEntityUpdate(wallet.getTransactionPin()),
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

    public Wallet toWallet(WalletEntity walletEntity) throws Exception {
        if (walletEntity == null){
            return null;
        }
        return new Wallet(
                walletEntity.getId(),
                _transactionPinMapper.toTransactionPin(walletEntity.getTransactionPinEntity()),
                walletEntity.getBalance(),
                _userMapper.toUser(walletEntity.getUserEntity()),
                walletEntity.getCreatedAt(),
                walletEntity.getUpdatedAt()
        );
    }
}
