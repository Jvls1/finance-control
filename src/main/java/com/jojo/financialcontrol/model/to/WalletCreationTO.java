package com.jojo.financialcontrol.model.to;

import jakarta.persistence.*;
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

    @NotBlank(message = "Month is mandatory")
    private Month month;

    @NotBlank(message = "Year is mandatory")
    private Year year;

    @NotBlank(message = "Wallet owner is mandatory")
    private UUID idWalletOwner;

    @JoinColumn(name = "id_user_collaborator")
    private UUID idWalletCollaborator;

}
