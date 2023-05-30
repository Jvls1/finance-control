package com.jojo.financialcontrol.web.model;

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
public class WalletCreationTO {

    private Month month;

    private Year year;

    @NotBlank(message = "Wallet owner is mandatory")
    private UUID idWalletOwner;

    private UUID idWalletCollaborator;

}
