package com.jojo.financialcontrol.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Month;
import java.time.Year;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletCreationDTO {

    private Month month;

    private Year year;

    @NotBlank(message = "Wallet owner is mandatory")
    private UUID idWalletOwner;

    private UUID idWalletCollaborator;

}
