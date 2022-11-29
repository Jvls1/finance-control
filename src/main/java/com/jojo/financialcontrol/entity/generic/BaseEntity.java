package com.jojo.financialcontrol.entity.generic;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    public abstract UUID getId();

    public abstract void setId(UUID id);
}
