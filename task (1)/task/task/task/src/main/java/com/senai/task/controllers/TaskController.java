package com.senai.task.controllers;

import com.senai.task.dtos.TaskDto;
import com.senai.task.repositories.TaskRepository;
import com.senai.task.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    /*
    @Autowired
    private TaskService service;

    @GetMapping("/task")
    public ResponseEntity<Object> obterTarefas() {
        return;
    }

    @PostMapping("/task")
    public ResponseEntity<Object> criarTask(@RequestBody @Valid TaskDto task) {
        return;
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Object> atualizarTask(@PathVariable Long id, @RequestBody @Valid TaskDto task) {
        return;
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Object> excluirTask(@PathVariable Long id) {
        return;
    }

 */
}