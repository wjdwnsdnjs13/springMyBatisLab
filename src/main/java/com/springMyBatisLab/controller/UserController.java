package com.springMyBatisLab.controller;

import com.springMyBatisLab.model.User;
import com.springMyBatisLab.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(User user){
        log.info("{}", user);
        if(user == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        Integer result = userService.signUp(user);
        if(result.equals(1)) return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(User user){
        log.info("{}", user);
        if(user == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        Integer result = userService.signIn(user);
        if(result.equals(1)) return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
