package com.jvls.financialcontrol.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private UUID id;

    @Column(name = "time_creation")
    private LocalDateTime timeCreated;

    @Column(name = "time_update")
    private LocalDateTime timeUpdate;

    @Column(name = "time_removed")
    private LocalDateTime timeRemoved;
}
