package br.api.walletapi.insfrastructure.mapper;

import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.insfrastructure.entities.TransactionPinEntity;
import br.api.walletapi.insfrastructure.entities.UserEntity;
import br.api.walletapi.insfrastructure.entities.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
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
}
