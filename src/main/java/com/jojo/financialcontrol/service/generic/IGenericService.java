package com.jojo.financialcontrol.service.generic;

import com.jojo.financialcontrol.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T extends BaseEntity> {

    List<T> findAll();

    Optional<T> findById(Integer id);

    void save(T entity);

    void deleteById(Integer idExpense);
}
