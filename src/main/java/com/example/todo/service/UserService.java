package com.example.todo.service;

import com.example.todo.domain.User;
import com.example.todo.dto.request.UserRequestDto;
import com.example.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public String save(UserRequestDto userRequestDto) {

        User user = User.builder()
                .email(userRequestDto.getEmail())
                .nickname(userRequestDto.getNickname())
                .password(bCryptPasswordEncoder.encode(userRequestDto.getPassword()))
                .build();

        userRepository.save(user);
        return user.getNickname();
    }
}
