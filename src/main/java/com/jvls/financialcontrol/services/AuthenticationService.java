package com.jvls.financialcontrol.services;

import java.time.LocalDateTime;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jvls.financialcontrol.dtos.SignInDTO;
import com.jvls.financialcontrol.dtos.UserCreationDTO;
import com.jvls.financialcontrol.entities.User;
import com.jvls.financialcontrol.exceptions.ConflictException;
import com.jvls.financialcontrol.exceptions.FinancialControlException;
import com.jvls.financialcontrol.exceptions.UserCreationException;
import com.jvls.financialcontrol.repositories.IUserRepository;
import com.jvls.financialcontrol.utils.StringUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public User signup(UserCreationDTO dto) throws FinancialControlException {
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
