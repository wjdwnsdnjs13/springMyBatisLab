package com.springMyBatisLab.service;

import com.springMyBatisLab.model.User;
import io.swagger.v3.oas.models.security.SecurityScheme;

public interface UserService {
    Integer signUp(User user);
    Integer signIn(User user);
}
