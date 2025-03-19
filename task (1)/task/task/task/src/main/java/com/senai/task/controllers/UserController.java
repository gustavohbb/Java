package com.senai.task.controllers;

import com.senai.task.dtos.TaskDto;
import com.senai.task.dtos.UserDto;
import com.senai.task.repositories.UserRepository;
import com.senai.task.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/user")
    public ResponseEntity<Object> obterUsuarios() {
        return;
    }

    @PostMapping("/user")
    public ResponseEntity<Object> criarUsuario(@RequestBody @Valid UserDto user) {
        return;
    }

    @PutMapping("/user/{email}")
    public ResponseEntity<Object> atualizarUsuario(@PathVariable String email, @RequestBody @Valid UserDto user) {
        return;
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<Object> excluirUsuario(@PathVariable String email) {
        return;
    }
}

