package br.api.walletapi.insfrastructure.client.apivalidate;

import br.api.walletapi.insfrastructure.client.apivalidate.response.ApiValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ApiValidationClient", url = "${client.url}")
public interface ApiValidationClient {
    @GetMapping
    ApiValidateResponse validate();
}
