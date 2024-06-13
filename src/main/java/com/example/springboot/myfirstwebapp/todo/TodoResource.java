package com.example.springboot.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
public class TodoResource {

    @Autowired
    private TodoService todoService;


    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username){

       return todoService.findByUserName(username);
    }

    @GetMapping("/users/todos/{id}")
    public Todo retrieveTodo(@PathVariable Integer id){
        return todoService.findById(id);
    }

    @DeleteMapping("/users/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer id){
        todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/todos/{id}")
    public Todo updateTodo(@PathVariable Integer id,@RequestBody Todo todo){                                 // along with id body will also be passed,
        todoService.updateTodo(id,todo);                                                                  //what is the JSON that i would want to update the todo with?
        return todo;                                                                          // so whatever todo is updated will be returned back
    }

    @PostMapping("/users/todos")
    public Todo createTodo(@RequestBody Todo todo){
        Todo createdTodo = todoService.addTodo(todo.getUsername(), todo.getDescription(),todo.getTargetDate(),todo.isDone());
        return createdTodo;
    }


}
