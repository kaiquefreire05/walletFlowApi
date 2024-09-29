package br.api.walletapi.insfrastructure.config;

import br.api.walletapi.application.gateway.*;
import br.api.walletapi.application.usecaseimpl.*;
import br.api.walletapi.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {

    @Bean
    public FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        return new FindWalletByTaxNumberImpl(findWalletByTaxNumberGateway);
    }

    @Bean
    public ConsultBalanceUseCase consultBalanceUseCase(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        return new ConsultBalanceImpl(findWalletByTaxNumberUseCase);
    }

    @Bean
    public TransactionPinValidationUseCase transactionPinValidationUseCase(TransactionPinValidationGateway transactionPinValidationGateway
            , UpdateTransactionalPinUseCase updateTransactionalPinUseCase) {
        return new TransactionPinValidationImpl(transactionPinValidationGateway, updateTransactionalPinUseCase);
    }

    @Bean
    public UpdateTransactionalPinUseCase updateTransactionalPinUseCase(UpdateTransactionPinGateway updateTransactionPinGateway) {
        return new UpdateTransactionalPinImpl(updateTransactionPinGateway);
    }

    @Bean
    public CreateTransactionalUseCase createTransactionalUseCase(CreateTransactionalGateway createTransactionalGateway) {
        return new CreateTransactionalImpl(createTransactionalGateway);
    }

    @Bean
    public UserNotificationUseCase userNotificationUseCase(UserNotificationGateway userNotificationGateway) {
        return new UserNotificationImpl(userNotificationGateway);
    }

    @Bean
    public TransferUseCase transferUseCase(TransferUseGateway transferGateway) {
        return new TransferUseImpl(transferGateway);
    }

    @Bean
    public TransactionValidationUseCase transactionValidationUseCase(TransactionValidationGateway transactionValidationGateway) {
        return new TransactionValidationImpl(transactionValidationGateway);
    }

}
