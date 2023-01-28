package com.jojo.financialcontrol.repository.generic;

import com.jojo.financialcontrol.entity.generic.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface IGenericRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {
}
