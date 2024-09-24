package br.api.walletapi.insfrastructure.config;

import br.api.walletapi.application.gateway.CreateUserGateway;
import br.api.walletapi.application.gateway.EmailAvailableGateway;
import br.api.walletapi.application.gateway.TaxNumberAvailableGateway;
import br.api.walletapi.application.usecaseimpl.CreateUserImpl;
import br.api.walletapi.application.usecaseimpl.EmailAvailableImpl;
import br.api.walletapi.application.usecaseimpl.TaxNumberAvailableImpl;
import br.api.walletapi.usecases.CreateUserUseCase;
import br.api.walletapi.usecases.EmailAvailableUseCase;
import br.api.walletapi.usecases.TaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        return new TaxNumberAvailableImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway) {
        return new EmailAvailableImpl(emailAvailableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase
            , EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        return new CreateUserImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGateway);
    }
}
