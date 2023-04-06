package com.jojo.financialcontrol.controller;


import com.jojo.financialcontrol.constants.Routes;
import com.jojo.financialcontrol.exception.InfoNotFoundException;
import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.model.to.UserCreationTO;
import com.jojo.financialcontrol.service.UserServiceImpl;
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
    public ResponseEntity<User> findById(@PathVariable("id") UUID idUser) throws InfoNotFoundException {
        Optional<User> user = userService.findById(idUser);
        if (user.isEmpty()) {
            throw new InfoNotFoundException("User not founded");
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody UserCreationTO userCreationTO) throws UserCreationException {
        User user = userService.createUser(userCreationTO);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") UUID idUser, @RequestBody UserCreationTO userCreationTO) throws Exception {
        User user = userService.updateUser(idUser, userCreationTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@PathVariable("id") UUID idUser) throws InfoNotFoundException {
        userService.deleteById(idUser);
        return ResponseEntity.ok("Deleted");
    }
}
