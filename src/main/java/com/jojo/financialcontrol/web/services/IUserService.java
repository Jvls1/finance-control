package com.jojo.financialcontrol.web.services;

import com.jojo.financialcontrol.infra.exception.UserCreationException;
import com.jojo.financialcontrol.domain.User;
import com.jojo.financialcontrol.web.model.UserCreationTO;
import com.jojo.financialcontrol.web.services.generic.IGenericCrudService;

import java.util.Optional;
import java.util.UUID;

public interface IUserService extends IGenericCrudService<User> {

    Optional<User> findByEmail(String email);

    User createUser(UserCreationTO userCreationTO) throws UserCreationException;

    //TODO: change de UserCreationTO to other Class
    User updateUser(UUID idUser, UserCreationTO userCreationTO) throws Exception;

}
