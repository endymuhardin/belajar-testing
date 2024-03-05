package com.muhardin.endy.belajar.testing.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity @Data
public class WalletTransaction {
    @Id 
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @NotNull @ManyToOne
    @JoinColumn(name = "id_wallet")
    private Wallet wallet;

    @NotNull
    private LocalDateTime transactionTime = LocalDateTime.now();

    @NotNull @Min(0)
    private BigDecimal amount;
}
