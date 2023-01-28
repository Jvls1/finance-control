package com.jojo.financialcontrol.service.interfaces;

import com.jojo.financialcontrol.entity.authentication.User;
import com.jojo.financialcontrol.service.generic.IGenericService;

public interface IUserService extends IGenericService<User> {

    User findByUsername(String username);
}
