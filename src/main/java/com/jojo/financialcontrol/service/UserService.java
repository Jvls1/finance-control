package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.authentication.User;
import com.jojo.financialcontrol.repository.IUserRepository;
import com.jojo.financialcontrol.service.generic.AGenericService;
import com.jojo.financialcontrol.service.interfaces.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AGenericService<User> implements IUserService {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    private final IUserRepository userRepository;

    protected UserService(IUserRepository userRepository, IUserRepository userRepository1) {
        super(userRepository);
        this.userRepository = userRepository1;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//    private IUserRepository userRepository;
//
//    private User findByUsername(String username) {
//        userRepository.
//    }

}
