package com.jojo.financialcontrol.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
@Getter
@Setter
@NoArgsConstructor
public class Expense extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "amount", precision = 8, scale = 2, nullable = false)
    private Double amount;

//    mudar data de registro para data da compra.
    @Column(name = "register_date", nullable = false)
    private LocalDate registerDate;

}
