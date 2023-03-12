package com.jojo.financialcontrol.to;

import com.jojo.financialcontrol.enums.EnumBuyMethod;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.model.Wallet;
import jakarta.persistence.*;
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
@Builder
public class ExpenseCreationTO {

    private String description;

    @NotBlank(message = "Amount is mandatory")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "1000000", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal amount;

    private LocalDate dateRegister;

    @NotBlank(message = "Wallet is mandatory")
    private UUID idWallet;

    @NotBlank(message = "Buy method is mandatory")
    private EnumBuyMethod enumBuyMethod;

}
