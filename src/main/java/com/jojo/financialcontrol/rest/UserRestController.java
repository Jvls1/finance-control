package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.entity.User;
import com.jojo.financialcontrol.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserRestController {

    private final UserServiceImpl userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") UUID idUser) {
        try {
            Optional<User> user = userService.findById(idUser);
            if (user.isPresent()) {
                return new ResponseEntity<>(user.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }

    @PostMapping("/user")
    public ResponseEntity<Object> save(@Valid @RequestBody User user) {
        try {
            userService.save(user);
            return ResponseEntity.ok("Created");
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.internalServerError().body("This email address is registered with another account.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Internal Error");
        }

    }
}
