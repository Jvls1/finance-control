package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends IGenericRepository<User> {

    Optional<User> findByEmail(String email);

    @Modifying
    @Query("update User u set u.timeRemoved = now() where u.id = :idUser")
    void updateUserById(UUID idUser);
}
