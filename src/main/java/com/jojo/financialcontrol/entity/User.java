package com.jojo.financialcontrol.entity;

import com.jojo.financialcontrol.entity.generic.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "usr")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "name", length = 255, nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(name = "password", length = 255, nullable = false)
    @Size(min = 8, max = 255)
    @NotBlank(message = "Password is mandatory")
    private String password;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    @Size(min = 8, max = 255)
    @NotBlank(message = "Email is mandatory")
    private String email;

    @OneToMany(mappedBy = "walletOwner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Wallet> walletsOwner;

    @OneToMany(mappedBy = "walletCollaborator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Wallet> walletsCollaborator;
}
