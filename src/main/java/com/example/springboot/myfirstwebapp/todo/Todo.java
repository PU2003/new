package com.example.springboot.myfirstwebapp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "todos")
public class Todo {
    @Id
    private Integer id;
    private String username;
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
