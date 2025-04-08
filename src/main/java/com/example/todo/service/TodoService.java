package com.example.todo.service;

import com.example.todo.domain.Daily;
import com.example.todo.domain.Status;
import com.example.todo.domain.Todo;
import com.example.todo.dto.request.TodoRequestDto;
import com.example.todo.dto.request.UpdateTodoRequestDto;
import com.example.todo.dto.response.TodoResponseDto;
import com.example.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    /* user id 기반으로 오늘 할 일 저장 */
    public Long saveTodo(TodoRequestDto todoRequestDto) {
        Todo todo = todoRepository.findByUserId(todoRequestDto.getUserId());
        return(todo.getId());
    }

    public Long saveDailyToto(TodoRequestDto todoRequestDto) {
        Todo request = todoRequestDto.toEntity();
               request.updateDaily(Daily.YES);
        Todo after = todoRepository.save(request);
        return after.getId();

    }

    public Long deleteById(TodoRequestDto todoRequestDto) {
        todoRepository.deleteById(todoRequestDto.getId());
        return todoRequestDto.getId();
    }

    public Long updateTodo(UpdateTodoRequestDto todoRequestDto) {
        Todo todo = todoRepository.findById(todoRequestDto.getId()).orElseThrow(
                () -> new IllegalArgumentException("Not Found : "+todoRequestDto.getId())
        );

        if(todoRequestDto.getType().equals("NNNN")){
            todo.updateStatus(Status.TODO);
        }else{
            todo.updateStatus(Status.DONE);
        }
        return todo.getId();
    }
}
