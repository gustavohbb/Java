package com.senai.task.controllers;

import com.senai.task.dtos.MensagemDto;
import com.senai.task.dtos.TaskDto;
import com.senai.task.repositories.TaskRepository;
import com.senai.task.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/task")
    public ResponseEntity<List<TaskDto>> obterTasks() {
        List<TaskDto> tasks = service.obterTasks();
        if (tasks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tasks);
        }
        return ResponseEntity.ok().body(tasks);
    }

    @PostMapping("/task")
    public ResponseEntity<MensagemDto> criarTask(@RequestBody @Valid TaskDto task) {
        MensagemDto mensagemDto = new MensagemDto();
        mensagemDto = service.criarTask(task);
        if (mensagemDto.isSucesso()) {
            return ResponseEntity.ok().body(mensagemDto);
        } else if (mensagemDto.getMensagem().equals("Usuário da tarefa não encontrado")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemDto);
        } else if (mensagemDto.getMensagem().equals("Usuário já possui agenda para a data informada")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(mensagemDto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemDto);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Object> atualizarTask(@PathVariable Long id, @RequestBody @Valid TaskDto task) {
        MensagemDto mensagemDto = new MensagemDto();
        mensagemDto = service.atualizarTask(task);
        if (mensagemDto.isSucesso()) {
            return ResponseEntity.ok().body(mensagemDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemDto);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Object> excluirTask(@PathVariable Long id) {
        MensagemDto mensagemDto = new MensagemDto();
        mensagemDto = service.deletarTask(id);
        if (mensagemDto.isSucesso()) {
            return ResponseEntity.ok().body(mensagemDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemDto);
    }
}