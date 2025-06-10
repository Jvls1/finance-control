package com.jojo.financialcontrol.controller;

import com.jojo.financialcontrol.constants.Routes;
import com.jojo.financialcontrol.dto.UserCreationDTO;
import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.service.UserServiceImpl;
import com.jojo.financialcontrol.utils.URIUtil;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
