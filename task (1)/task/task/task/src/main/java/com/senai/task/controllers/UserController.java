package com.senai.task.controllers;

import com.senai.task.dtos.MensagemDto;
import com.senai.task.dtos.TaskDto;
import com.senai.task.dtos.UserDto;
import com.senai.task.repositories.UserRepository;
import com.senai.task.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> obterUsuarios() {
        return ResponseEntity.ok().body(service.obterUsuarios());
    }

    @PostMapping("/user")
    public ResponseEntity<MensagemDto> criarUsuario(@RequestBody @Valid UserDto user) {
        MensagemDto mensagemDto = new MensagemDto();
        mensagemDto = service.inserirUsuario(user);
        if (mensagemDto.isSucesso()) {
            return ResponseEntity.ok().body(mensagemDto);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(mensagemDto);
    }

    @PutMapping("/user/{email}")
    public ResponseEntity<MensagemDto> atualizarUsuario(@PathVariable String email, @RequestBody @Valid UserDto user) {
        MensagemDto mensagemDto = new MensagemDto();
        mensagemDto = service.atualizarUsuario(user);
        if (mensagemDto.isSucesso()) {
            return ResponseEntity.ok().body(mensagemDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemDto);
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<MensagemDto> excluirUsuario(@PathVariable String email) {
        MensagemDto mensagemDto = new MensagemDto();
        mensagemDto = service.deletarUsuario(email);
        if (mensagemDto.isSucesso()) {
            return ResponseEntity.ok().body(mensagemDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemDto);
    }
}

