package com.jojo.financialcontrol.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;
import java.time.Year;
import java.util.List;

@Entity
@Table(name = "wallet")
@Getter
@Setter
@NoArgsConstructor
public class Wallet extends BaseEntity {

    @Column(name = "month", nullable = false)
    @NotBlank(message = "Month is mandatory")
    private Month month;

    @Column(name = "year", nullable = false)
    @NotBlank(message = "Year is mandatory")
    private Year year;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Income> incomes;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Expense> expenses;

    @ManyToOne
    @JoinColumn(name = "id_user_owner", nullable = false)
    @NotBlank(message = "Wallet owner is mandatory")
    private User walletOwner;

    @ManyToOne
    @JoinColumn(name = "id_user_collaborator")
    private User walletCollaborator;
}
