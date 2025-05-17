package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.AuthenticationNotFoundException;
import com.jojo.financialcontrol.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;

@SessionScope
@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements ISessionService {

    private final IUserService iUserService;

    @Override
    public User sessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new AuthenticationNotFoundException();
        }
        Optional<User> userOptional = iUserService.findByEmail(authentication.getName());
        if (userOptional.isEmpty()) {
            throw new AuthenticationNotFoundException("User not founded");
        }
        return userOptional.get();
    }
}
