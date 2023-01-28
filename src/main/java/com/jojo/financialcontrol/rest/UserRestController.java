package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.entity.authentication.User;
import com.jojo.financialcontrol.response.ResponseHandler;
import com.jojo.financialcontrol.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;

    PasswordEncoder passwordEncoder;

    @GetMapping("/login/{username}")
    private ResponseEntity<Object> login(@PathVariable("username") String username) {

        User user = userService.findByUsername(username);

        return ResponseHandler.saveResponse(user);
    }

    @PostMapping("/register")
    private ResponseEntity<Object> register(@RequestBody User userParam) {
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
