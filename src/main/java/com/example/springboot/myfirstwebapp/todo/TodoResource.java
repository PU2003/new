package com.example.springboot.myfirstwebapp.todo;

import com.example.springboot.myfirstwebapp.jpa.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class TodoResource {

//    @Autowired
//    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;



    @GetMapping("/users/findAll/todos")
    public List<Todo> retrieveTodos(){
       return todoRepository.findAll();
    }

    @GetMapping("/users/todos/{id}")
    public Optional<Todo> retrieveTodo(@PathVariable Integer id){
        return todoRepository.findById(id);
    }

    @DeleteMapping("/users/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer id){
        todoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/todos/{id}")
    public Todo updateTodo(@PathVariable Integer id,@RequestBody Todo todo){                                 // along with id body will also be passed,
         todoRepository.deleteById(id);                                                               //what is the JSON that i would want to update the todo with?     // so whatever todo is updated will be returned back
         Todo updated = todoRepository.save(todo);
         return updated;
    }

    @PostMapping("/users/todos")
    public Todo createTodo(@RequestBody Todo todo){
        Todo createdTodo = todoRepository.save(todo);
        return createdTodo;
    }


}
