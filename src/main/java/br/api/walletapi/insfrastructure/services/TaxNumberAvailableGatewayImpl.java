package br.api.walletapi.insfrastructure.services;

import br.api.walletapi.application.gateway.TaxNumberAvailableGateway;
import br.api.walletapi.insfrastructure.repositories.UserEntityRepository;
import org.springframework.stereotype.Service;

import static br.api.walletapi.insfrastructure.utils.Utilies.log;

@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {
    // Dependencies Injection
    private final UserEntityRepository _userEntityRepository;

    public TaxNumberAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        _userEntityRepository = userEntityRepository;
    }

    // Method
    @Override
    public Boolean isTaxNumberAvailable(String taxNumber) {
        log.info("Start checking if TaxNumber is available::TaxNumberAvailableGatewayImpl");
        return !_userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
