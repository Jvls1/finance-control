package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.service.generic.IGenericCrudService;

import java.util.Optional;

public interface IUserService extends IGenericCrudService<User> {

    Optional<User> findByEmail(String email);
}
