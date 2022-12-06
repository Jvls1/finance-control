package com.jojo.financialcontrol.repository;

import com.jojo.financialcontrol.entity.User;
import com.jojo.financialcontrol.repository.generic.IGenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepository extends IGenericRepository<User> {

}
