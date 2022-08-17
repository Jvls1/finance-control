package com.jojo.financialcontrol.service.generic;

import com.jojo.financialcontrol.entity.BaseEntity;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;

import java.util.List;
import java.util.Optional;

public abstract class AGenericService<T extends BaseEntity> implements IGenericService<T> {

    private final IGenericRepository<T> IGenericRepository;

    protected AGenericService(IGenericRepository<T> IGenericRepository) {
        this.IGenericRepository = IGenericRepository;
    }

    @Override
    public List<T> findAll() {
        return IGenericRepository.findAll();
    }

    @Override
    public Optional<T> findById(Integer id) {
        return IGenericRepository.findById(id);
    }

    @Override
    public void save(T entity) {
        IGenericRepository.save(entity);
    }

    @Override
    public void deleteById(Integer idExpense) {
        IGenericRepository.deleteById(idExpense);
    }
}
