package com.jojo.financialcontrol.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    public abstract Integer getId();

    public abstract void setId(Integer id);
}
