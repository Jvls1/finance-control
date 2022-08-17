package com.jojo.financialcontrol.repository.generic;

import com.jojo.financialcontrol.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepository<T extends BaseEntity> extends JpaRepository<T, Integer> {
}
