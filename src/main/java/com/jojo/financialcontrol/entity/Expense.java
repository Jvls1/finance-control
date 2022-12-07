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

    @Column(name = "register_date", nullable = false)
    private LocalDate registerDate;
    
    @ManyToOne
    @JoinColumn(name = "usr_id", nullable = false)
    private User user;

    @Column(name = "buy_method", nullable = false)
    private EnumBuyMethod enumBuyMethod;
}
