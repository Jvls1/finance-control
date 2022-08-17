package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.entity.Expense;
import com.jojo.financialcontrol.entity.authentication.User;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface IUserRepository extends IGenericRepository<User> {

    User findByUsername(String username);
}
