package com.example.todo.dto.request;

import com.example.todo.domain.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequestDto {

    private Long userId;
    private String content;

    @Builder
    public Todo toEntity() {

        return
                Todo.builder()
                        .content(this.content)
                        .userId(this.userId)
                        .build();
    }

}
