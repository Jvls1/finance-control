package com.jojo.financialcontrol.model;

import com.jojo.financialcontrol.model.generic.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "wallet")
@Getter
@Setter
@NoArgsConstructor
public class Wallet extends BaseEntity {

    @Column(name = "month", nullable = false)
    @NotBlank(message = "Month is mandatory")
    private LocalDate month;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Income> incomes;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Expense> expenses;

    @ManyToOne
    @JoinColumn(name = "id_user_owner", nullable = false)
    @NotBlank(message = "Wallet owner is mandatory")
    private User walletOwner;

    @ManyToOne
    @JoinColumn(name = "id_user_collaborator")
    private User walletCollaborator;
}
