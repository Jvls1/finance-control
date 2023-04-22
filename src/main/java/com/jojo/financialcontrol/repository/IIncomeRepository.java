package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.Income;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IIncomeRepository extends IGenericRepository<Income> {

    Page<Income> findAllByWalletWalletOwnerId(Pageable page, UUID idUserOwner);

    Optional<Income> findByIdAndWalletWalletOwnerId(UUID idIncome, UUID idUserOwner);

    @Transactional
    @Modifying
    @Query("""
            update Income i 
               set i.timeRemoved = CURRENT_TIMESTAMP() 
             where i.id = :idIncome 
            """)
    void deleteByIncomeId(@Param("idIncome") UUID idIncome);
}
