package br.api.walletapi.insfrastructure.dto.requests;

import br.api.walletapi.domain.enums.UserTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(@NotBlank String email, @NotBlank String password, @NotBlank String taxNumber
        , @NotBlank String fullname, @NotNull UserTypeEnum type
    , @NotBlank String pin) {
}
