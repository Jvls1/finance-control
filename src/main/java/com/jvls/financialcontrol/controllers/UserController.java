package com.jvls.financialcontrol.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jvls.financialcontrol.constants.Routes;
import com.jvls.financialcontrol.dtos.UserCreationDTO;
import com.jvls.financialcontrol.entities.User;
import com.jvls.financialcontrol.exceptions.InfoNotFoundException;
import com.jvls.financialcontrol.exceptions.UserCreationException;
import com.jvls.financialcontrol.services.UserServiceImpl;
import com.jvls.financialcontrol.utils.URIUtil;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(Routes.USER)
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody UserCreationDTO userCreationTO) throws UserCreationException {
        User user = userService.createUser(userCreationTO);
        return ResponseEntity.created(URIUtil.getUri(user.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") UUID idUser) throws InfoNotFoundException {
        Optional<User> user = userService.findById(idUser);
        if (user.isEmpty()) {
            throw new InfoNotFoundException("User not founded");
        }
        return ResponseEntity.ok().body(user.get());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable("id") UUID idUser, @RequestBody UserCreationDTO userCreationTO) throws Exception {
        userService.updateUser(idUser, userCreationTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") UUID idUser) throws InfoNotFoundException {
        userService.deleteById(idUser);
        return ResponseEntity.noContent().build();
    }
}
