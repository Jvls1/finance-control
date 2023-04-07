package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.model.to.UserCreationTO;
import com.jojo.financialcontrol.repository.IUserRepository;
import com.jojo.financialcontrol.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final IUserRepository iUserRepository;

    @Override
    public Page<User> findAll(Integer page, Integer rows) {
        return iUserRepository.findAll(PageRequest.of(page, rows));
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

    @Override
    public User createUser(UserCreationTO userCreationTO) throws UserCreationException {
        if (!StringUtil.isEmailValid(userCreationTO.getEmail())) {
            throw new UserCreationException("Invalid Email");
        }

        User user = new User();
        BeanUtils.copyProperties(userCreationTO, user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setTimeCreated(LocalDateTime.now());
        user.setTimeUpdate(LocalDateTime.now());

        return iUserRepository.save(user);
    }

    public User updateUser(UUID idUser, UserCreationTO userCreationTO) throws Exception {
        Optional<User> userOptional = iUserRepository.findById(idUser);
        if (userOptional.isEmpty()) {
            throw new InfoNotFoundException("User not found");
        }
        if (userCreationTO == null) {
            //TODO: change for a specific Exception
            throw new Exception("Need the creation object");
        }
        User user = userOptional.get();
        if (userCreationTO.getEmail() != null) {
            if (!StringUtil.isEmailValid(userCreationTO.getEmail())) {
                throw new UserCreationException("Invalid Email");
            }
            user.setEmail(userCreationTO.getEmail());
        }
        if (userCreationTO.getName() != null) {
            user.setName(userCreationTO.getName());
        }
        if (userCreationTO.getPassword() != null) {
            user.setPassword(bCryptPasswordEncoder.encode(userCreationTO.getPassword()));
        }
//        TODO: think the best impl to update a user...
        throw new UnsupportedOperationException("Update user not working...");
    }

    @Override
    public void deleteById(UUID idUser) throws InfoNotFoundException {
        boolean existsById = iUserRepository.existsById(idUser);
        if (!existsById) {
            throw new InfoNotFoundException("User not found");
        }
        iUserRepository.deactivateUserByUserId(idUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return iUserRepository.findByEmail(email);
    }

}
