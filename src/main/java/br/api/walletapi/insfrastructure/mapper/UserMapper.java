package br.api.walletapi.insfrastructure.mapper;

import br.api.walletapi.domain.entities.TaxNumber;
import br.api.walletapi.domain.entities.User;
import br.api.walletapi.insfrastructure.dto.requests.CreateUserRequest;
import br.api.walletapi.insfrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    // Methods
    public UserEntity toUserEntity(User user) {
        return new UserEntity(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            user.getTaxNumber().getValue(),
            user.getFullname(),
            user.getType(),
            user.getCreatedAt(),
            user.getUpdateAt()
        );
    }

    public User toUser(CreateUserRequest request) throws Exception {
        return new User(
                request.email(),
                request.password(),
                new TaxNumber(request.taxNumber()),
                request.fullname(),
                request.type()
        );
    }
}
