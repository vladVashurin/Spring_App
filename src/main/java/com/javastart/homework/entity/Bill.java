package com.javastart.homework.entity;

import com.javastart.homework.controller.dto.BillRequestDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private Boolean isDefault;

    public Bill() {
    }

    public Bill(BigDecimal amount, Boolean isDefault) {
        this.amount = amount;
        this.isDefault = isDefault;
    }

    public Bill(BillRequestDTO billRequestDTO) {
        amount = billRequestDTO.getAmount();
        isDefault = billRequestDTO.getDefault();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id) && Objects.equals(amount, bill.amount) && Objects.equals(isDefault, bill.isDefault);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, isDefault);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amount=" + amount +
                ", isDefault=" + isDefault +
                '}';
    }
}
