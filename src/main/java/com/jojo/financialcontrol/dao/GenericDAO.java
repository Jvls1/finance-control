package com.jojo.financialcontrol.dao;

import com.jojo.financialcontrol.entity.BaseEntity;

import java.util.List;

public interface GenericDAO<T extends BaseEntity> {

    T findById(Long id);

    List<T> findAll();

    void save(T t);

    void deleteById(Long id);
}
