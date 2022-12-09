package com.jojo.financialcontrol.entity;

import com.jojo.financialcontrol.entity.generic.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "walletOwner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Wallet> walletsOwner;

    @OneToMany(mappedBy = "walletCollaborator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Wallet> walletsCollaborator;
}
