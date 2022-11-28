package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserRepository iUserRepository;
}
