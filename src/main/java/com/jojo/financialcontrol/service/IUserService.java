package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.model.to.UserCreationTO;
import com.jojo.financialcontrol.service.generic.IGenericCrudService;

import java.util.Optional;
import java.util.UUID;

public interface IUserService extends IGenericCrudService<User> {

    Optional<User> findByEmail(String email);

    User createUser(UserCreationTO userCreationTO) throws UserCreationException;

    //TODO: change de UserCreationTO to other Class
    User updateUser(UUID idUser, UserCreationTO userCreationTO) throws Exception;
}
