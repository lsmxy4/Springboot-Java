package com.example.demo.controller;

import com.example.demo.dto.CreateTodoRequest;
import com.example.demo.dto.TodoResponse;
import com.example.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public TodoResponse create(@RequestBody CreateTodoRequest request){
        return todoService.create(request);
    }

    @GetMapping
    public List<TodoResponse> findAll(){
        return todoService.findAll();
    }
}
