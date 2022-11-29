package com.jojo.financialcontrol.rest;


import com.jojo.financialcontrol.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserRestController {

    private final UserServiceImpl userService;

}
