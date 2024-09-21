package br.api.walletapi.application.gateway;

public interface TaxNumberAvailableGateway {
    Boolean isTaxNumberAvailable(String taxNumber);
}
