package com.jojo.financialcontrol.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="income")
@Getter
@Setter
@NoArgsConstructor
public class Income extends BaseEntity{

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "amount", precision = 8, scale = 2, nullable = false)
    private Double amount;

    @Column(name = "register_date", nullable = false)
    private LocalDate registerDate;

    @ManyToOne
    @JoinColumn(name = "income_type_id", nullable = false)
    private IncomeType expenseTypeId;
}
