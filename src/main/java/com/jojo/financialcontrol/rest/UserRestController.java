package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.entity.User;
import com.jojo.financialcontrol.response.ResponseHandler;
import com.jojo.financialcontrol.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserRestController {

    private final UserServiceImpl userService;

    @PostMapping("/user")
    public ResponseEntity<Object> save(@RequestBody User userParam) {
        if (userParam != null) {
            userService.save(userParam);
        }
        return ResponseHandler.saveResponse(userParam);
    }
}
