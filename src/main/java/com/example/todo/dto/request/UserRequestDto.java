package com.example.todo.dto.request;

import com.example.todo.domain.Todo;
import com.example.todo.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserRequestDto {

    private String email;

    private String nickname;

    private String password;

    @Builder
    public User toEntity(){

        return User.builder()
                .email(this.email)
                .nickname(this.nickname)
                .password(this.password)
                .build();
    }
}
