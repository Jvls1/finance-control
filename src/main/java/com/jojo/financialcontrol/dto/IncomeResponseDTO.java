package com.jojo.financialcontrol.dto;

import com.jojo.financialcontrol.model.Income;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomeResponseDTO {

    private String description;

    private BigDecimal amount;

    private LocalDate dateRegister;

    private UUID idWallet;

    public IncomeResponseDTO setValues(Income income) {
        description = income.getDescription();
        amount = income.getAmount();
        dateRegister = income.getDateRegister();
        idWallet = income.getWallet().getId();
        return this;
    }

}
