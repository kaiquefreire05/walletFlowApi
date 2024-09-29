package br.api.walletapi.insfrastructure.controllers;

import br.api.walletapi.insfrastructure.dto.requests.CreateUserRequest;
import br.api.walletapi.insfrastructure.dto.response.BaseResponse;
import br.api.walletapi.insfrastructure.mapper.UserMapper;
import br.api.walletapi.usecases.CreateUserUseCase;
import br.api.walletapi.usecases.EmailAvailableUseCase;
import br.api.walletapi.usecases.TaxNumberAvailableUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.api.walletapi.insfrastructure.utils.Utilies.log;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    // Dependencies Injection
    private final CreateUserUseCase _createUserUseCase;
    private final UserMapper _userMapper;
    private final EmailAvailableUseCase _emailAvailableUseCase;
    private final TaxNumberAvailableUseCase _taxNumberAvailableUseCase;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper, EmailAvailableUseCase emailAvailableUseCase
            , TaxNumberAvailableUseCase taxNumberAvailableUseCase) {
        _createUserUseCase = createUserUseCase;
        _userMapper = userMapper;
        _emailAvailableUseCase = emailAvailableUseCase;
        _taxNumberAvailableUseCase = taxNumberAvailableUseCase;
    }

    // Methods
    @PostMapping("/createUser")
    //@ResponseBody(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse<String>> createUser(@Valid @RequestBody CreateUserRequest request) throws Exception {
        log.info("Start of user creation::UserController");
        _emailAvailableUseCase.emailAvailable(request.email());
        _taxNumberAvailableUseCase.isTaxNumberAvailable(request.taxNumber());
        _createUserUseCase.Create(_userMapper.toUser(request), request.pin());
        log.info("User created with success::UserController");
        return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponse.<String>builder().success(true).message("User created successfully").build());
    }
}
