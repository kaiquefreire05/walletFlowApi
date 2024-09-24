package br.api.walletapi.insfrastructure.services;

import br.api.walletapi.application.gateway.EmailAvailableGateway;
import br.api.walletapi.insfrastructure.repositories.UserEntityRepository;
import org.springframework.stereotype.Service;

import static br.api.walletapi.insfrastructure.utils.Utilies.log;

@Service
public class EmailAvailableGatewayImpl implements EmailAvailableGateway {
    // Dependencies Injection
    private final UserEntityRepository _userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        _userEntityRepository = userEntityRepository;
    }

    // Method
    @Override
    public Boolean isAvailable(String email) {
        log.info("Start checking if Email is available::EmailAvailableGatewayImpl");
        return !_userEntityRepository.existsByEmail(email);
    }
}
