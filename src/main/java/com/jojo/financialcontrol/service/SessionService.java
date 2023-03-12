package com.jojo.financialcontrol.service;

import com.jojo.financialcontrol.exception.AuthenticationNotFoundException;
import com.jojo.financialcontrol.model.User;

public interface SessionService {

    User sessionUser();
}
