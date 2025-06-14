package com.jojo.financialcontrol.controller;

import com.jojo.financialcontrol.constants.Routes;
import com.jojo.financialcontrol.dto.LoginResponseDTO;
import com.jojo.financialcontrol.dto.SignInDTO;
import com.jojo.financialcontrol.dto.UserCreationDTO;
import com.jojo.financialcontrol.exception.FinanceControlException;
import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.service.AuthenticationService;
import com.jojo.financialcontrol.service.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(Routes.AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody UserCreationDTO dto) throws FinanceControlException {
        return ResponseEntity.ok().body(authenticationService.signup(dto));
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> signin(@Valid @RequestBody SignInDTO dto) throws InfoNotFoundException {
        User authenticatedUser = authenticationService.signin(dto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        var responseDto = new LoginResponseDTO(jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(responseDto);
    }
}
