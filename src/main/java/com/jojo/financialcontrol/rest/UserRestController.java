package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.entity.Expense;
import com.jojo.financialcontrol.entity.authentication.User;
import com.jojo.financialcontrol.response.ResponseHandler;
import com.jojo.financialcontrol.service.ExpenseService;
import com.jojo.financialcontrol.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;

//    @GetMapping("/users")
//    List<Expense> findAll() {
//        return userService.findAll();
//    }

    PasswordEncoder passwordEncoder;

    @PostMapping("/users")
    private ResponseEntity<Object> save(@RequestBody User userParam) {
        if (userParam != null) {
            if (userParam.getEmail() != null && userParam.getUsername() != null &&
                    userParam.getPassword() != null) {

                userParam.setPassword(passwordEncoder.encode(userParam.getPassword()));

                userService.save(userParam);
            }
        }
        return ResponseHandler.saveResponse(userParam);
    }



}
