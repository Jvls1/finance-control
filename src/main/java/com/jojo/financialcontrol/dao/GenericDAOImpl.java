package com.jojo.financialcontrol.dao;

import com.jojo.financialcontrol.entity.BaseEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class GenericDAOImpl<T extends BaseEntity> implements GenericDAO<T> {

    EntityManager entityManager;

    private Class<T> entityClass;

    public GenericDAOImpl() {
    }

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void save(BaseEntity baseEntity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
