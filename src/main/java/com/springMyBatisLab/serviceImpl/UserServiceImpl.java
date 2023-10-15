package com.springMyBatisLab.serviceImpl;

import com.springMyBatisLab.mapper.UserMapper;
import com.springMyBatisLab.model.User;
import com.springMyBatisLab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor //maper 객체에 autowired달아줘도 됨.
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Transactional
    @Override
    public Integer signUp(User user) {
        User user1 = userMapper.getUserById(user);
        if(user1 != null) return 0;
        Integer result = userMapper.signUp(user);
        return result;
    }

    @Override
    public Integer signIn(User user){
        User user1 = userMapper.signIn(user);
        Integer result = (user1!=null?0:1);
        return result;
    }
}
