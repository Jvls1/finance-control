package com.jvls.financialcontrol.services.generic;

import org.springframework.data.domain.Page;

import com.jvls.financialcontrol.entities.BaseEntity;
import com.jvls.financialcontrol.exceptions.InfoNotFoundException;
import com.jvls.financialcontrol.exceptions.UserCreationException;

import java.util.Optional;
import java.util.UUID;

public interface IGenericCrudService<T extends BaseEntity> {

    Page<T> findAll(Integer page, Integer row);

    Optional<T> findById(UUID idEntity);

    void save(T expense) throws UserCreationException;

    void deleteById(UUID idExpense) throws InfoNotFoundException;
}
