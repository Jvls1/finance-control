package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.Wallet;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IWalletRepository extends IGenericRepository<Wallet> {

    @Query("""
            select w
              from Wallet w
             where 1=1 
               and w.walletOwner.id = :idUser
                or w.walletCollaborator.id = :idUser
            """)
    Page<Wallet> findAllByWalletOwnerIdOrWalletCollaboratorId(Pageable page, UUID idUser);

    List<Wallet> findAllByWalletOwnerId(UUID idUserOwner);

    @Transactional
    @Modifying
    @Query("""
            update Wallet w 
               set w.walletCollaborator = null
             where w.id = :idWallet 
               and w.walletCollaborator.id = :idUserCollaborator
             """)
    void removeWalletCollaboratorByWalletIdAndUserId(UUID idWallet, UUID idUserCollaborator);

    @Transactional
    @Modifying
    @Query("""
             update Wallet w 
               set w.timeRemoved = CURRENT_TIMESTAMP() 
             where w.id = :idWallet 
             """)
    void deleteByWalletId(UUID idWallet);

}
