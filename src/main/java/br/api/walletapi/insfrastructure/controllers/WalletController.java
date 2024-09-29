package br.api.walletapi.insfrastructure.controllers;

import br.api.walletapi.domain.entities.Transaction;
import br.api.walletapi.domain.exceptions.NotFoundException;
import br.api.walletapi.insfrastructure.dto.requests.TransferRequest;
import br.api.walletapi.insfrastructure.dto.response.ConsultBalanceResponse;
import br.api.walletapi.insfrastructure.dto.response.BaseResponse;
import br.api.walletapi.usecases.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    // Dependencies Injection
    private final ConsultBalanceUseCase _consultBalanceUseCase;
    private final TransferUseCase _transferUseCase;
    private final CreateTransactionalUseCase _createTransactionalUseCase;
    private final FindWalletByTaxNumberUseCase _findWalletByTaxNumberUseCase;
    private final TransactionValidationUseCase _transactionValidationUseCase;
    private final TransactionPinValidationUseCase _transactionPinValidationUseCase;
    private final UserNotificationUseCase _userNotificationUseCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUseCase transferUseCase
            , CreateTransactionalUseCase createTransactionalUseCase
            , FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidationUseCase transactionValidationUseCase, TransactionPinValidationUseCase transactionPinValidationUseCase, UserNotificationUseCase userNotificationUseCase) {
        _consultBalanceUseCase = consultBalanceUseCase;
        _transferUseCase = transferUseCase;
        _createTransactionalUseCase = createTransactionalUseCase;
        _findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        _transactionValidationUseCase = transactionValidationUseCase;
        _transactionPinValidationUseCase = transactionPinValidationUseCase;
        _userNotificationUseCase = userNotificationUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {
        var balance = _consultBalanceUseCase.consultBalance(taxNumber);
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest transferRequest) throws Exception {

        var fromWallet = _findWalletByTaxNumberUseCase.findByTaxNumber(transferRequest.fromTaxNumber());
        _transactionPinValidationUseCase.validate(fromWallet.getTransactionPin(), transferRequest.pin());
        var toWallet = _findWalletByTaxNumberUseCase.findByTaxNumber(transferRequest.toTaxNumber());
        var transaction = _createTransactionalUseCase.create(toWallet, fromWallet, transferRequest.value());

        _transactionValidationUseCase.validate(transaction);
        _transferUseCase.transfer(transaction);
        _userNotificationUseCase.notification(transaction, fromWallet.getUser().getEmail());

        return BaseResponse.<String>builder().success(true).message("Transfer successful").build();
    }

}
