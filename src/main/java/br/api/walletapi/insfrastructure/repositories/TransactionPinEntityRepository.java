package br.api.walletapi.insfrastructure.repositories;

import br.api.walletapi.insfrastructure.entities.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
