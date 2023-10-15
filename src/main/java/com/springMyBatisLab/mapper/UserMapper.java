package com.springMyBatisLab.mapper;

import com.springMyBatisLab.model.User;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Integer signUp(User user);

    User signIn(User user);

    User getUserById(User user);
}
