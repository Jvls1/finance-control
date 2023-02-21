package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.service.UserServiceImpl;
import com.jojo.financialcontrol.to.UserCreationTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") UUID idUser) {
        try {
            Optional<User> user = userService.findById(idUser);
            if (user.isEmpty()) {
                return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }

    @PostMapping("/user")
    public ResponseEntity<Object> save(@Valid @RequestBody UserCreationTO userCreationTO) throws UserCreationException {
        userService.createUser(userCreationTO);
        return ResponseEntity.ok("Created");
    }
}
