package com.jojo.financialcontrol.model.to;

import com.jojo.financialcontrol.enums.EnumBuyMethod;
import com.jojo.financialcontrol.model.Expense;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
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
