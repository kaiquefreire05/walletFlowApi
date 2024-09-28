package br.api.walletapi.insfrastructure.services;

import br.api.walletapi.application.gateway.FindWalletByTaxNumberGateway;
import br.api.walletapi.domain.entities.Wallet;
import br.api.walletapi.insfrastructure.entities.WalletEntity;
import br.api.walletapi.insfrastructure.mapper.WalletMapper;
import br.api.walletapi.insfrastructure.repositories.WalletEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {
    // Dependencies Injection
    private WalletEntityRepository _walletEntityRepository;
    private WalletMapper _walletMapper;

    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        _walletEntityRepository = walletEntityRepository;
        _walletMapper = walletMapper;
    }

    // Method
    @Override
    public Wallet findWalletByTaxNumber(String taxNumber) throws Exception {
        return _walletMapper.toWallet(_walletEntityRepository.findByUserEntityTaxNumber(taxNumber));
    }
}
