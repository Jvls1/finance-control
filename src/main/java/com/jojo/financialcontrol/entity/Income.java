package com.jojo.financialcontrol.entity;

import com.jojo.financialcontrol.entity.generic.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "income")
@Getter
@Setter
@NoArgsConstructor
public class Income extends BaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "amount", precision = 8, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "register_date", nullable = false)
    private LocalDate registerDate;

    @ManyToOne
    @JoinColumn(name="usr_id", nullable=false)
    private User user;

}
