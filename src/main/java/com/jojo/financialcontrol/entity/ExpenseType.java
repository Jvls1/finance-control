package com.jojo.financialcontrol.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="expense_type")
@Getter
@Setter
@NoArgsConstructor
public class ExpenseType extends BaseEntity{

    @Column(name = "name")
    private String name;

}

