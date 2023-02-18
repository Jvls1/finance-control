package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.model.User;
import com.jojo.financialcontrol.exception.UserCreationException;
import com.jojo.financialcontrol.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            if (user.isEmpty()) {
                return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
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
            return ResponseEntity.badRequest().body("This email address is registered with another account.");
        } catch (UserCreationException ex) {
            return ResponseEntity.badRequest().body("This is a invalid Email");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error");
        }
    }
}
