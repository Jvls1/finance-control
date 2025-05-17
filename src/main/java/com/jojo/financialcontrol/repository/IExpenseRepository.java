package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.Expense;
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
public interface IExpenseRepository extends IGenericRepository<Expense> {

    Page<Expense> findAllByWalletWalletOwnerId(Pageable page, UUID idUserOwner);

    Optional<Expense> findByIdAndWalletWalletOwnerId(UUID idExpense, UUID idUserOwner);

    @Transactional
    @Modifying
    @Query("""
            update Expense e 
               set e.timeRemoved = CURRENT_TIMESTAMP() 
             where e.id = :idExpense 
            """)
    void deleteByExpenseId(@Param("idExpense") UUID idExpense);
}
