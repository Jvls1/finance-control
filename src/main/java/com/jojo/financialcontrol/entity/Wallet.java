package com.jojo.financialcontrol.entity;

import com.jojo.financialcontrol.entity.generic.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "wallet")
@Getter
@Setter
@NoArgsConstructor
public class Wallet extends BaseEntity {

    @Column(name = "month", nullable = false)
    private LocalDate month;

//    @ManyToOne
//    @JoinColumn(name = "usr_id", nullable = false)
//    private User walletOwner;
//
//    @ManyToOne
//    @JoinColumn(name = "usr_id", nullable = false)
//    private User walletCollaborator;
}
