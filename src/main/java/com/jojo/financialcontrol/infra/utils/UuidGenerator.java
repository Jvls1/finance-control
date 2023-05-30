package com.jojo.financialcontrol.infra.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class UuidGenerator implements IdentifierGenerator {

    public static final String STRATEGY_PATH = "com.jojo.financialcontrol.utils.UuidGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return UUID.randomUUID();
    }
}
