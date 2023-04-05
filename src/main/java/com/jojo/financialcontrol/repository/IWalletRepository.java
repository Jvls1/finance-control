package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IWalletRepository extends IGenericRepository<Wallet> {

    Page<Wallet> findAllByWalletOwnerId(Pageable page, UUID idUserOwner);

    Optional<Wallet> findByWalletOwnerId(UUID idUserOwner);

    @Modifying
    @Query("""
            update Wallet w 
               set w.walletCollaborator = null
             where w.id = :idWallet 
               and w.walletCollaborator.id = :idUserCollaborator
             """)
    void removeWalletCollaboratorByWalletIdAndUserId(UUID idWallet,UUID idUserCollaborator);
}
