package com.example.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount,"prachi","Learn AWS", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"prachi","Learn DevOps", LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todosCount,"prachi","Learn Full Stack Development", LocalDate.now().plusYears(3),false));

    }

    public List<Todo> findByUserName(String username){
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Integer id,Todo todo) {
        deleteById(id);
        todos.add(todo);
    }

    public Todo addTodo(String username,String description,LocalDate targetDate,boolean done) {
        Todo todo = new Todo(++todosCount,username,description,targetDate,done);
        todos.add(todo);
        return todo;
    }
}
