package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.User;
import com.jojo.financialcontrol.entity.Wallet;
import com.jojo.financialcontrol.repository.IUserRepository;
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
    public User save(User user) {
        if (user != null && user.getEmail() != null && user.getName() != null && user.getPassword() != null)
            return iUserRepository.save(user);
        
        return user;
    }

    @Override
    public void deleteById(UUID idUser) {
        iUserRepository.deleteById(idUser);
    }
}
