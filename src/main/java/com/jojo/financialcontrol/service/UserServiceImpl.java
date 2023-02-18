package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.repository.IUserRepository;
import com.jojo.financialcontrol.utils.StringUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
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
    public void save(User user) {
        if (!StringUtil.isEmailValid(user.getEmail())) {
            throw new UserCreationException("Invalid Email");
        }
        iUserRepository.save(user);
    }

    @Override
    public void deleteById(UUID idUser) {
        iUserRepository.deleteById(idUser);
    }
}
