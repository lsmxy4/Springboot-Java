package com.example.demo.service;

import com.example.demo.domain.Todo;
import com.example.demo.dto.CreateTodoRequest;
import com.example.demo.dto.TodoResponse;
import com.example.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {

    private  final TodoRepository todoRepository;

    public TodoResponse create(CreateTodoRequest request){
        Todo todo = new Todo();
        todo.update(request.getTitle(), request.getContent(), false);

        Todo saved = todoRepository.save(todo);

        return  new TodoResponse(saved);
    }

    public List<TodoResponse> findAll(){
        return todoRepository.findAll()
                .stream()
                .map(TodoResponse::new)
                .collect(Collectors.toList());
    }
}
