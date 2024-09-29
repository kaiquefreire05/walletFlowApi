package br.api.walletapi.domain.entities;

import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.enums.UserTypeEnum;
import br.api.walletapi.domain.exceptions.TransferException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wallet {

    // Attributes
    private Long id;
    private TransactionPin transactionPin;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    // Builders
    public Wallet(Long id, TransactionPin transactionPin, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Wallet(TransactionPin transactionPin, BigDecimal balance, User user) {
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet() {
    }

    // Methods
    public void transfer(BigDecimal value) throws TransferException {
        if (this.user.getType() == UserTypeEnum.SHOPKEEPER){
            throw new TransferException(ErrorCodeEnum.TR0001.getCode(), ErrorCodeEnum.TR0001.getMessage());
        }

        if (this.balance.compareTo(value) < 0){
            throw new TransferException(ErrorCodeEnum.TR0002.getCode(), ErrorCodeEnum.TR0002.getMessage());
        }
        this.balance = this.balance.subtract(value);
    }

    public void receiveValue(BigDecimal value) {
        this.balance.add(value);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveTransfer(BigDecimal value) {
        this.balance = this.balance.add(value);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    // HashCode and Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wallet wallet)) return false;

        if (getId() != null ? !getId().equals(wallet.getId()) : wallet.getId() != null) return false;
        if (!getTransactionPin().equals(wallet.getTransactionPin())) return false;
        if (!getBalance().equals(wallet.getBalance())) return false;
        if (!getUser().equals(wallet.getUser())) return false;
        if (!getCreatedAt().equals(wallet.getCreatedAt())) return false;
        return getUpdateAt() != null ? getUpdateAt().equals(wallet.getUpdateAt()) : wallet.getUpdateAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getTransactionPin().hashCode();
        result = 31 * result + getBalance().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + (getUpdateAt() != null ? getUpdateAt().hashCode() : 0);
        return result;
    }
}
