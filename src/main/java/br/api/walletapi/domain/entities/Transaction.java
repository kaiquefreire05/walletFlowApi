package br.api.walletapi.domain.entities;

import br.api.walletapi.domain.enums.TransactionStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    // Attributes
    private Long id;
    private Wallet fromWallet;
    private Wallet toWallet;
    private BigDecimal value;
    private TransactionStatusEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Builders
    public Transaction(Long id, Wallet fromWallet, Wallet toWallet, BigDecimal value, TransactionStatusEnum status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Transaction(Wallet fromWallet, Wallet toWallet, BigDecimal value) {
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = TransactionStatusEnum.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public Transaction() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wallet getFromWallet() {
        return fromWallet;
    }

    public void setFromWallet(Wallet fromWallet) {
        this.fromWallet = fromWallet;
    }

    public Wallet getToWallet() {
        return toWallet;
    }

    public void setToWallet(Wallet toWallet) {
        this.toWallet = toWallet;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // HashCode and Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getFromWallet().equals(that.getFromWallet())) return false;
        if (!getToWallet().equals(that.getToWallet())) return false;
        if (!getValue().equals(that.getValue())) return false;
        if (getStatus() != that.getStatus()) return false;
        if (!getCreatedAt().equals(that.getCreatedAt())) return false;
        return getUpdatedAt() != null ? getUpdatedAt().equals(that.getUpdatedAt()) : that.getUpdatedAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getFromWallet().hashCode();
        result = 31 * result + getToWallet().hashCode();
        result = 31 * result + getValue().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        return result;
    }
}
