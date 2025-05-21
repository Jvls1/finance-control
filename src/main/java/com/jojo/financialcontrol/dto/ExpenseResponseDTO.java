package com.jojo.financialcontrol.dto;

import com.jojo.financialcontrol.enums.EnumBuyMethod;
import com.jojo.financialcontrol.model.Expense;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponseDTO {

    private String description;

    private BigDecimal amount;

    private LocalDate dateRegister;

    private UUID idWallet;

    private EnumBuyMethod enumBuyMethod;

    public ExpenseResponseDTO setValues(Expense expense) {
        description = expense.getDescription();
        amount = expense.getAmount();
        dateRegister = expense.getDateRegister();
        idWallet = expense.getWallet().getId();
        enumBuyMethod = expense.getEnumBuyMethod();
        return this;
    }

}
