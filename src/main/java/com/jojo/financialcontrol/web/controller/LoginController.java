package com.jojo.financialcontrol.web.controller;

import com.jojo.financialcontrol.infra.constants.Routes;
import com.jojo.financialcontrol.infra.exception.InfoNotFoundException;
import com.jojo.financialcontrol.domain.User;
import com.jojo.financialcontrol.web.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(Routes.LOGIN)
@RequiredArgsConstructor
public class LoginController {

    private final UserServiceImpl userService;

    @RequestMapping()
    public ResponseEntity<Object> login(Authentication authentication) throws InfoNotFoundException {
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED!");
        }

        Optional<User> userOpt = userService.findByEmail(authentication.getName());

        if (userOpt.isEmpty()) {
            throw new InfoNotFoundException("User not found");
        }

        User user = userOpt.get();

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
