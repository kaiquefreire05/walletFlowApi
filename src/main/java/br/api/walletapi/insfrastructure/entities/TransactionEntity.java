package br.api.walletapi.insfrastructure.entities;

import br.api.walletapi.domain.enums.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Transactions")
public class TransactionEntity {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FromWallet")
    private WalletEntity fromWallet;

    @ManyToOne
    @JoinColumn(name = "ToWallet")
    private WalletEntity toWallet;

    @Column(name = "TransactionalValue", nullable = false)
    private BigDecimal value;

    @Column(name = "Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    public TransactionEntity(LocalDateTime updatedAt, LocalDateTime createdAt, TransactionStatusEnum status
            , BigDecimal value, WalletEntity fromWallet, WalletEntity toWallet) {
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.status = status;
        this.value = value;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
    }
}
