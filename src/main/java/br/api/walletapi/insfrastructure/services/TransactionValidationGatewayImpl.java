package br.api.walletapi.insfrastructure.services;

import br.api.walletapi.application.gateway.TransactionValidationGateway;
import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.insfrastructure.client.apivalidate.ApiValidationService;
import org.springframework.stereotype.Service;

@Service
public class TransactionValidationGatewayImpl implements TransactionValidationGateway {
    // Dependencies Injection
    private final ApiValidationService _apiValidationService;

    public TransactionValidationGatewayImpl(ApiValidationService apiValidationService) {
        _apiValidationService = apiValidationService;
    }

    // Method
    @Override
    public Boolean validateTransaction(Transaction transaction) {
        var response = _apiValidationService.validate();
        if (response == null) {
            return false;
        }
        return response.success();
    }
}
