package com.jojo.financialcontrol.service.generic;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.model.BaseEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IGenericCrudService<T extends BaseEntity> {

    Page<T> findAll(Integer page, Integer row);

    Optional<T> findById(UUID idExpense);

    void save(T expense) throws UserCreationException;

    void deleteById(UUID idExpense) throws InfoNotFoundException;
}
