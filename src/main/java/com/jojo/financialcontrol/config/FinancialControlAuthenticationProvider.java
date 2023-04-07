package com.jojo.financialcontrol.config;

import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FinancialControlAuthenticationProvider implements AuthenticationProvider {

    private final UserServiceImpl userService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<User> userOptional = userService.findByEmail(username);

        if (userOptional.isEmpty()) {
            throw new BadCredentialsException("No user registered with this details!");
        }

        if (passwordEncoder.matches(password, userOptional.get().getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, password, null);
        } else {
            throw new BadCredentialsException("Invalid password!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
