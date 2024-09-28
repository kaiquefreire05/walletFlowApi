package br.api.walletapi.insfrastructure.controllers;

import br.api.walletapi.domain.exceptions.NotFoundException;
import br.api.walletapi.insfrastructure.dto.requests.TransferRequest;
import br.api.walletapi.insfrastructure.dto.response.ConsultBalanceResponse;
import br.api.walletapi.insfrastructure.dto.response.BaseResponse;
import br.api.walletapi.usecases.ConsultBalanceUseCase;
import br.api.walletapi.usecases.TransferUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    // Dependencies Injection
    private ConsultBalanceUseCase _consultBalanceUseCase;
    private TransferUseCase _transferUseCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUseCase transferUseCase) {
        _consultBalanceUseCase = consultBalanceUseCase;
        _transferUseCase = transferUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {
        var balance = _consultBalanceUseCase.consultBalance(taxNumber);
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest transferRequest) throws Exception {
        _transferUseCase.transfer(transferRequest.fromTaxNumber(), transferRequest.toTaxNumber()
                , transferRequest.value(), transferRequest.pin());
        return BaseResponse.<String>builder().success(true).message("Transfer successful").build();
    }

}
