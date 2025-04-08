package com.example.todo.dto.response;

import com.example.todo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String nickname;

    @Builder
    public UserResponseDto(User user){
        this.nickname = user.getNickname();
    }
}
