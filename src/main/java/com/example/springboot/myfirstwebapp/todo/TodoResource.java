package com.example.springboot.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
