package com.jojo.financialcontrol.entity;

import com.jojo.financialcontrol.entity.generic.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "wallet")
@Getter
@Setter
@NoArgsConstructor
public class Wallet extends BaseEntity {

    @Column(name = "month", nullable = false)
    private LocalDate month;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Income> incomes;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Expense> expenses;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User walletOwner;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User walletCollaborator;
}
