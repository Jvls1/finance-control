package com.jvls.financialcontrol.repositories.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.jvls.financialcontrol.entities.BaseEntity;

import java.util.UUID;

@NoRepositoryBean
public interface IGenericRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {
}
