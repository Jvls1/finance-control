package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.User;
import com.jojo.financialcontrol.entity.Wallet;
import com.jojo.financialcontrol.exception.UserCreationException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {

    List<User> findAll();

    Optional<User> findById(UUID idUser);

    User save(User wallet) throws UserCreationException;

    void deleteById(UUID idUser);

}
