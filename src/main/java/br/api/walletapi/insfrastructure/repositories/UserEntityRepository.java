package br.api.walletapi.insfrastructure.repositories;

import br.api.walletapi.insfrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
    Boolean existsByTaxNumber(String taxNumber);
    Boolean existsByEmail(String email);
}
