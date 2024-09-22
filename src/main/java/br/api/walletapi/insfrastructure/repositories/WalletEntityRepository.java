package br.api.walletapi.insfrastructure.repositories;

import br.api.walletapi.insfrastructure.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
}
