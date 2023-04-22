package com.jojo.financialcontrol.model.to;

import com.jojo.financialcontrol.enums.EnumBuyMethod;
import com.jojo.financialcontrol.model.Expense;
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
public class IncomeResponseTO {

    private String description;

    private BigDecimal amount;

    private LocalDate dateRegister;

    private UUID idWallet;

    public IncomeResponseTO setValues(Income income) {
        description = income.getDescription();
        amount = income.getAmount();
        dateRegister = income.getDateRegister();
        idWallet = income.getWallet().getId();
        return this;
    }

}
