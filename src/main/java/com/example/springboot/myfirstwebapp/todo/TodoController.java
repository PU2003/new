package com.example.springboot.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

     @Autowired
     private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
     public String listAllTodos(ModelMap model){

        List<Todo> todos = todoService.findByUserName("prachi");
        model.addAttribute("todos",todos);
         return "listTodos";
     }
}
