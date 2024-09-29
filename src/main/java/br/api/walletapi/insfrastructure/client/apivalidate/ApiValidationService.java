package br.api.walletapi.insfrastructure.client.apivalidate;

import br.api.walletapi.insfrastructure.client.apivalidate.response.ApiValidateResponse;
import org.springframework.stereotype.Service;

@Service
public class ApiValidationService {
    // Dependencies Injection
    private final ApiValidationClient _apiValidationClient;

    public ApiValidationService(ApiValidationClient apiValidationClient) {
        _apiValidationClient = apiValidationClient;
    }

    // Method
    public ApiValidateResponse validate() {
        try {
            return _apiValidationClient.validate();

        } catch (Exception ex) {
            return null;
        }

    }
}
