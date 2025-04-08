package com.example.todo.controller;

import com.example.todo.dto.request.UserRequestDto;
import com.example.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    /***
     * 회원정보로 회원가입
     * @param userRequestDto
     * @return
     */
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UserRequestDto  userRequestDto){

        return ResponseEntity.ok().body(userService.save(userRequestDto));
    }
}
