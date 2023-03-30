package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IIncomeRepository extends IGenericRepository<Income> {

    Page<Income> findAllByWalletWalletOwnerId(Pageable page, UUID idUserOwner);

    Optional<Income> findByIdAndWalletWalletOwnerId(UUID idIncome, UUID idUserOwner);
}
