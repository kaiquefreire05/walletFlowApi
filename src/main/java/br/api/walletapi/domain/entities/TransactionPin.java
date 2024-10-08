package br.api.walletapi.domain.entities;

import br.api.walletapi.domain.enums.ErrorCodeEnum;
import br.api.walletapi.domain.exceptions.TransactionPinException;

import java.time.LocalDateTime;

public class TransactionPin {

    // Attributes
    private Long id;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    // Builders
    public TransactionPin(Long id, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt
            , LocalDateTime updateAt) {
        this.id = id;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public TransactionPin(String pin) throws TransactionPinException {
        setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {}

    // Methods
    private void pinIsValid(String pin) throws TransactionPinException {
        if (pin.length() != 8) {
            throw new TransactionPinException(ErrorCodeEnum.TRP0001.getMessage(), ErrorCodeEnum.TRP0001.getCode());
        }
    }

    public void restaureAttempt(){
        this.attempt = 3;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException {
        pinIsValid(pin);
        this.pin = pin;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt() {
        if (this.attempt == 1) {
            this.blocked = true;
            this.attempt = 0;
        } else {
            this.attempt = this.attempt - 1;
        }
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
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

    // HashCode and Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionPin that)) return false;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getPin().equals(that.getPin())) return false;
        if (!getAttempt().equals(that.getAttempt())) return false;
        if (!getBlocked().equals(that.getBlocked())) return false;
        if (!getCreatedAt().equals(that.getCreatedAt())) return false;
        return getUpdateAt() != null ? getUpdateAt().equals(that.getUpdateAt()) : that.getUpdateAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getPin().hashCode();
        result = 31 * result + getAttempt().hashCode();
        result = 31 * result + getBlocked().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + (getUpdateAt() != null ? getUpdateAt().hashCode() : 0);
        return result;
    }
}
