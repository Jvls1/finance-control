package com.jojo.financialcontrol.entity;

import com.jojo.financialcontrol.entity.generic.BaseEntity;
import com.jojo.financialcontrol.enums.EnumBuyMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
@Getter
@Setter
@NoArgsConstructor
public class Expense extends BaseEntity {

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "amount", precision = 8, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "date_register", nullable = false)
    private LocalDate dateRegister;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_wallet", nullable = false)
    private Wallet wallet;

    @Column(name = "buy_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumBuyMethod enumBuyMethod;
}
