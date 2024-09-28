package br.api.walletapi.insfrastructure.services;

import br.api.walletapi.application.gateway.CreateUserGateway;
import br.api.walletapi.domain.entities.User;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.insfrastructure.entities.TransactionPinEntity;
import br.api.walletapi.insfrastructure.mapper.TransactionPinMapper;
import br.api.walletapi.insfrastructure.mapper.UserMapper;
import br.api.walletapi.insfrastructure.mapper.WalletMapper;
import br.api.walletapi.insfrastructure.repositories.TransactionPinEntityRepository;
import br.api.walletapi.insfrastructure.repositories.UserEntityRepository;
import br.api.walletapi.insfrastructure.repositories.WalletEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import static br.api.walletapi.insfrastructure.utils.Utilies.log;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {
    // Dependencies Injection
    private UserEntityRepository _userEntityRepository;
    private TransactionPinEntityRepository _transactionPinEntityRepository;
    private WalletEntityRepository _walletEntityRepository;
    private UserMapper _userMapper;
    private TransactionPinMapper _transactionPinMapper;
    private WalletMapper _walletMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository
            , TransactionPinEntityRepository transactionPinEntityRepository, WalletEntityRepository walletEntityRepository
            , UserMapper userMapper, TransactionPinMapper transactionPinMapper, WalletMapper walletMapper) {
        _userEntityRepository = userEntityRepository;
        _transactionPinEntityRepository = transactionPinEntityRepository;
        _walletEntityRepository = walletEntityRepository;
        _userMapper = userMapper;
        _transactionPinMapper = transactionPinMapper;
        _walletMapper = walletMapper;
    }

    // Method
    @Override
    @Transactional
    public Boolean create(User user, Wallet wallet) {

        try {
            log.info("Start of user creation::CreateUserGatewayImpl");
            var userSaved = _userEntityRepository.save(_userMapper.toUserEntity(user));
            var transactionPinSaved = _transactionPinEntityRepository
                    .save(_transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            _walletEntityRepository.save(_walletMapper.toWalletEntity(wallet, userSaved, transactionPinSaved));
            log.info("User has been successfully registered::CreateUserGatewayImpl");
            return true;

        } catch (Exception ex) {
            log.info("There was an error creating the user. Error details: {}::CreateUserGatewayImpl", ex.getMessage());
            return false;
        }

    }
}
