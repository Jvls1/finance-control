package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.entity.authentication.User;
import com.jojo.financialcontrol.repository.IUserRepository;
import com.jojo.financialcontrol.service.generic.AGenericService;
import com.jojo.financialcontrol.service.interfaces.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class UserService extends AGenericService<User> implements IUserService {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    protected UserService(IUserRepository userRepository) {
        super(userRepository);
    }

//    private IUserRepository userRepository;
//
//    private User findByUsername(String username) {
//        userRepository.
//    }

}
