package com.jojo.financialcontrol.controller;


import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.model.to.UserCreationTO;
import com.jojo.financialcontrol.service.UserServiceImpl;
import com.jojo.financialcontrol.constants.Routes;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(Routes.USER)
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") UUID idUser) {
        Optional<User> user = userService.findById(idUser);
        if (user.isEmpty()) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody UserCreationTO userCreationTO) throws UserCreationException {
        User user = userService.createUser(userCreationTO);
        return ResponseEntity.ok(user);
    }
}
