package com.jvls.financialcontrol.services;

import java.util.Optional;
import java.util.UUID;

import com.jvls.financialcontrol.dtos.UserCreationDTO;
import com.jvls.financialcontrol.entities.User;
import com.jvls.financialcontrol.exceptions.UserCreationException;
import com.jvls.financialcontrol.services.generic.IGenericCrudService;

public interface IUserService extends IGenericCrudService<User> {

    Optional<User> findByEmail(String email);

    User createUser(UserCreationDTO userCreationTO) throws UserCreationException;

    //TODO: change de UserCreationTO to other Class
    User updateUser(UUID idUser, UserCreationDTO userCreationTO) throws Exception;

}
