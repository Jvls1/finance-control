package com.jojo.financialcontrol.dto;

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
public class IncomeCreationDTO {

    private String description;

    @NotBlank(message = "Amount is mandatory")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "1000000", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal amount;

    private LocalDate dateRegister;

    @NotBlank(message = "Wallet is mandatory")
    private UUID idWallet;

}
