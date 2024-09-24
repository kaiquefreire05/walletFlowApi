package br.api.walletapi.insfrastructure.dto.requests;

import br.api.walletapi.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullname, UserTypeEnum type
    , String pin) {
}
