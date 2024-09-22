package br.api.walletapi.insfrastructure.repositories;

import br.api.walletapi.insfrastructure.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
}
