package com.jojo.financialcontrol.model;

import com.jojo.financialcontrol.model.generic.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "income")
@Getter
@Setter
@NoArgsConstructor
public class Income extends BaseEntity {

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "amount", precision = 8, scale = 2, nullable = false)
    @NotBlank(message = "Amount is mandatory")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "1000000", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal amount;

    @Column(name = "date_register", nullable = false)
    private LocalDate dateRegister;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", nullable = false)
    @NotBlank(message = "User is mandatory")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_wallet", nullable = false)
    @NotBlank(message = "Wallet is mandatory")
    private Wallet wallet;

}
