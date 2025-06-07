package com.todoer.todoer.controllers;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoer.todoer.dto.MessageDto;
import com.todoer.todoer.dto.TodoDto;
import com.todoer.todoer.models.Todo;
import com.todoer.todoer.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("")
    public ResponseEntity<Todo> createTodo(@RequestBody TodoDto body) {
        Todo todo = todoService.createTodo(body);

        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todoList = todoService.getAllTodos();
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable("id") Long id) {
        Todo todo = todoService.getTodo(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> patchTodo(@PathVariable("id") Long id, @RequestBody TodoDto body) {
        Todo todo = todoService.patchTodo(id, body);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteTodo(@PathVariable("id") Long id){
        todoService.deleteTodo(id);
        MessageDto message = new MessageDto("Deleted todo {" + id + "} successfully"); 
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
