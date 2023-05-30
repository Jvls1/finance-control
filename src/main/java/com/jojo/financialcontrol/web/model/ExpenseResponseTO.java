package com.jojo.financialcontrol.web.model;

import com.jojo.financialcontrol.domain.EnumBuyMethod;
import com.jojo.financialcontrol.domain.Expense;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponseTO {

    private String description;

    private BigDecimal amount;

    private LocalDate dateRegister;

    private UUID idWallet;

    private EnumBuyMethod enumBuyMethod;

    public ExpenseResponseTO setValues(Expense expense) {
        description = expense.getDescription();
        amount = expense.getAmount();
        dateRegister = expense.getDateRegister();
        idWallet = expense.getWallet().getId();
        enumBuyMethod = expense.getEnumBuyMethod();
        return this;
    }

}
