package com.jojo.financialcontrol.service.generic;

import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.model.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IGenericCrudService<T extends BaseEntity> {

    List<T> findAll();

    Optional<T> findById(UUID idExpense);

    void save(T expense) throws UserCreationException;

    void deleteById(UUID idExpense);
}
