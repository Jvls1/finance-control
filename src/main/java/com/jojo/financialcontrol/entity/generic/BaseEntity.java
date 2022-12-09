package com.jojo.financialcontrol.entity.generic;

import com.jojo.financialcontrol.utils.UuidGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GenericGenerator(name="uuid_generator", strategy = UuidGenerator.STRATEGY_PATH)
    @GeneratedValue(generator = "uuid_generator")
    private UUID id;

}
