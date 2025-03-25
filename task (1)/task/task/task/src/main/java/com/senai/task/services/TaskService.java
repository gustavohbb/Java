package com.senai.task.services;

import com.senai.task.dtos.TaskDto;
import com.senai.task.models.TaskModel;
import com.senai.task.models.UserModel;
import com.senai.task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    @Autowired
    TaskRepository repository;

    public List<TaskDto> obterTasks () {
        List<TaskModel> tasks = new ArrayList<>();
        List<TaskDto> tasksDto = new ArrayList<>();
        repository.findAll();
        for (TaskModel task : tasks) {
            TaskDto taskTranferir = new TaskDto();
            taskTranferir.setNome(task.getNome());
            taskTranferir.setDescricao(task.getDescricao());
            taskTranferir.setAgendamento(task.getAgendamento());
            taskTranferir.setStatus(task.getStatus());
            taskTranferir.setEmail(task.getUsuario().getEmail());
        }
        return tasksDto;
    }


}
