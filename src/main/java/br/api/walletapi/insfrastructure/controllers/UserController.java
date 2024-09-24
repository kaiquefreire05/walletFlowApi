package br.api.walletapi.insfrastructure.controllers;

import br.api.walletapi.insfrastructure.dto.requests.CreateUserRequest;
import br.api.walletapi.insfrastructure.dto.response.BaseResponse;
import br.api.walletapi.insfrastructure.mapper.UserMapper;
import br.api.walletapi.usecases.CreateUserUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.api.walletapi.insfrastructure.utils.Utilies.log;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    // Dependencies Injection
    private final CreateUserUseCase _createUserUseCase;
    private final UserMapper _userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        _createUserUseCase = createUserUseCase;
        _userMapper = userMapper;
    }

    // Methods
    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws Exception {
        log.info("Start of user creation::UserController");
        _createUserUseCase.Create(_userMapper.toUser(request), request.pin());
        log.info("User created with success::UserController");
        return BaseResponse.<String>builder().success(true).message("User created successfully").build();
    }
}
