package br.api.walletapi.insfrastructure.services;

import br.api.walletapi.application.gateway.TransactionPinValidationGateway;
import br.api.walletapi.domain.entities.TransactionPin;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static br.api.walletapi.insfrastructure.utils.Utilies.log;

@Service
public class TransactionPinValidationGatewayImpl implements TransactionPinValidationGateway {

    @Override
    public boolean validate(TransactionPin transactionPin, String pin) {
        log.info("Start of transaction password validation::TransactionPinValidationGatewayImpl");
        if (!Objects.equals(transactionPin.getPin(), pin)) {
            log.info("Incorrect pin::TransactionPinValidationGatewayImpl");
            return false;
        }
        log.info("Correct pin::TransactionPinValidationGatewayImpl");
        return true;
    }
}
