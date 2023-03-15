package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.repository.IUserRepository;
import com.jojo.financialcontrol.model.to.UserCreationTO;
import com.jojo.financialcontrol.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<User> findById(UUID idUser) {
        return iUserRepository.findById(idUser);
    }

    @Override
    public void save(User user) throws UserCreationException {
        if (!StringUtil.isEmailValid(user.getEmail())) {
            throw new UserCreationException("Invalid Email");
        }
        iUserRepository.save(user);
    }

    public void createUser(UserCreationTO userCreationTO) throws UserCreationException {
        if (!StringUtil.isEmailValid(userCreationTO.getEmail())) {
            throw new UserCreationException("Invalid Email");
        }

        User user = new User();
        BeanUtils.copyProperties(userCreationTO, user);
        user.setTimeCreated(LocalDateTime.now());
        user.setTimeUpdate(LocalDateTime.now());

        iUserRepository.save(user);
    }

    @Override
    public void deleteById(UUID idUser) {
        iUserRepository.deleteById(idUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.of(iUserRepository.findByEmail(email));
    }

}
