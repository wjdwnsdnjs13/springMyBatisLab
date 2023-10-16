package com.springMyBatisLab.serviceImpl;

import com.springMyBatisLab.mapper.UserMapper;
import com.springMyBatisLab.model.User;
import com.springMyBatisLab.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor //maper 객체에 autowired달아줘도 됨.
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public Integer signUp(User signUpUser) {
        signUpUser.setPassword(passwordEncoder.encode(signUpUser.getPassword()));
        User user = userMapper.getUserById(signUpUser);
        if(user != null) return 0;
        Integer result = userMapper.signUp(signUpUser);
        return result;
    }

    @Override
    public Integer signIn(User signInUser){
        log.info("{}", signInUser);
//        암호화된 비밀번호가 salt 값이 랜덤이고 찾을 수 없기 때문에 DB에서 일치 여부 확인할 수 없음
//        따라서 불러와서 matches 메소드 사용해야됨.
        User user = userMapper.signIn(signInUser);
        if(user == null) return 0;
        Integer result = passwordEncoder.matches(signInUser.getPassword(), user.getPassword())?1:0;
        return result;
    }
}
