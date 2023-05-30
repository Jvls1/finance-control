package com.jojo.financialcontrol.domain;

import com.jojo.financialcontrol.infra.utils.UuidGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GenericGenerator(name="uuid_generator", strategy = UuidGenerator.STRATEGY_PATH)
    @GeneratedValue(generator = "uuid_generator")
    private UUID id;

    @Column(name = "time_creation")
    private LocalDateTime timeCreated;

    @Column(name = "time_update")
    private LocalDateTime timeUpdate;

    @Column(name = "time_removed")
    private LocalDateTime timeRemoved;

}
