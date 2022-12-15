package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.entity.User;
import com.jojo.financialcontrol.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserRestController {

    private final UserServiceImpl userService;

    @PostMapping("/user")
    public ResponseEntity<Object> save(@Valid @RequestBody User user) {
        try {
            userService.save(user);
            return ResponseEntity.ok("Created");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error");
        }

    }
}
