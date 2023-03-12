package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends IGenericRepository<User> {

    User findByEmail(String email);

}
