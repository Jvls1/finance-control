package com.jvls.financialcontrol.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jvls.financialcontrol.entities.User;
import com.jvls.financialcontrol.repositories.generic.IGenericRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends IGenericRepository<User> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query("""
             update User u 
               set u.timeRemoved = CURRENT_TIMESTAMP() 
             where u.id = :idUser
            """)
    void deleteUserById(@Param("idUser") UUID idUser);
}
