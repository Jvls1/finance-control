package com.jojo.financialcontrol.entity;

import com.jojo.financialcontrol.entity.generic.BaseEntity;
import com.jojo.financialcontrol.enums.EnumBuyMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
@Getter
@Setter
@NoArgsConstructor
public class Expense extends BaseEntity {

    @Column(name = "description", length = 100, nullable = false)
    @NotBlank(message = "Description is mandatory")
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

    @Column(name = "buy_method")
    @Enumerated(EnumType.STRING)
    private EnumBuyMethod enumBuyMethod;
}
