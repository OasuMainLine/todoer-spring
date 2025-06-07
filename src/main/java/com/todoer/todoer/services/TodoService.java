package com.todoer.todoer.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.todoer.todoer.dto.TodoDto;
import com.todoer.todoer.models.Todo;
import com.todoer.todoer.respositories.TodoRepository;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(TodoDto todo) {
        Todo createdTodo = new Todo();

        createdTodo.setName(todo.name());
        createdTodo.setIsCompleted(todo.isCompleted());
        return todoRepository.save(createdTodo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        return todo;
    }

    public Todo patchTodo(Long id, TodoDto update) {
        Todo todoForUpdate = getTodo(id);
        if (todoForUpdate == null) {
            return null;
        }

        if (update.name() != null) {
            todoForUpdate.setName(update.name());
        }
        if (update.isCompleted() != null) {
            todoForUpdate.setIsCompleted(update.isCompleted());
        }
        return todoRepository.save(todoForUpdate);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
