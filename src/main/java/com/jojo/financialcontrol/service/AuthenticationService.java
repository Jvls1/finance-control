package com.jojo.financialcontrol.service;

import java.time.LocalDateTime;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jojo.financialcontrol.dto.SignInDTO;
import com.jojo.financialcontrol.dto.UserCreationDTO;
import com.jojo.financialcontrol.exception.ConflictException;
import com.jojo.financialcontrol.exception.FinanceControlException;
import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.repository.IUserRepository;
import com.jojo.financialcontrol.utils.StringUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public User signup(UserCreationDTO dto) throws FinanceControlException {
        var now = LocalDateTime.now();
        if (!StringUtil.isEmailValid(dto.getEmail())) {
            throw new UserCreationException("Invalid Email");
        }
        if (iUserRepository.existsByEmail(dto.getEmail())) {
            throw new ConflictException("Email");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setTimeCreated(now);
        user.setTimeUpdate(now);

        return iUserRepository.save(user);
    }

    public User signin(SignInDTO dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

        return iUserRepository.findByEmail(dto.getEmail()).orElseThrow();
    }
}
