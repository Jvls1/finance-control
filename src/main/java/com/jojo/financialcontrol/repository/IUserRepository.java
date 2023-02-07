package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.entity.User;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends IGenericRepository<User> {

}