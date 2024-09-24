package br.api.walletapi.insfrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TransactionPin")
public class TransactionPinEntity {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Pin", nullable = false)
    private String pin;

    @Column(name = "Attempt", nullable = false)
    private Integer attempt;

    @Column(name = "Blocked", nullable = false)
    private Boolean blocked;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    // Builder

    public TransactionPinEntity(String pin, Boolean blocked, Integer attempt, LocalDateTime createdAt
            , LocalDateTime updatedAt) {
        this.pin = pin;
        this.blocked = blocked;
        this.attempt = attempt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
