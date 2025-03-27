package com.senai.task.services;

import com.senai.task.dtos.MensagemDto;
import com.senai.task.dtos.TaskDto;
import com.senai.task.models.TaskModel;
import com.senai.task.models.UserModel;
import com.senai.task.repositories.TaskRepository;
import com.senai.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    public List<TaskDto> obterTasks() {
        List<TaskModel> tasks = new ArrayList<>();
        List<TaskDto> tasksDto = new ArrayList<>();
        tasks = taskRepository.findAll();
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

    public MensagemDto criarTask(TaskDto task) {
        MensagemDto mensagemDto = new MensagemDto();
        Optional<UserModel> usuarioExistente = userRepository.findByEmail(task.getEmail());
        UserModel userTask = new UserModel();
        userTask = usuarioExistente.get();
        Optional<List<TaskModel>> taskExiste = taskRepository.findByEmail(userTask);
        if (usuarioExistente.isPresent()) {
            if (taskExiste.isPresent()) {
                List<TaskModel> tasks = taskExiste.get();
                for (TaskModel tasksUsuario : tasks) {
                    if (tasksUsuario.getAgendamento().compareTo(task.getAgendamento()) == 0) {
                        mensagemDto.setMensagem("Usuário já possui agenda para a data informada");
                        mensagemDto.setSucesso(false);
                        return mensagemDto;
                    }
                }
            }
            mensagemDto.setMensagem("tarefa inserida com sucesso");
            mensagemDto.setSucesso(true);
            TaskModel taskInserida = new TaskModel();
            taskInserida.setNome(task.getNome());
            taskInserida.setDescricao(task.getDescricao());
            taskInserida.setAgendamento(task.getAgendamento());
            taskInserida.setStatus(task.getStatus());
            taskInserida.setUsuario(usuarioExistente.get());
            taskRepository.save(taskInserida);
            return mensagemDto;
        }
        mensagemDto.setMensagem("Usuário da tarefa não encontrado");
        mensagemDto.setSucesso(false);
        return mensagemDto;
    }

    public MensagemDto atualizarTask(TaskDto taskAtualizar) {
        MensagemDto mensagemDto = new MensagemDto();
        Optional<UserModel> usuarioExistente = userRepository.findByEmail(taskAtualizar.getEmail());
        Optional<TaskModel> taskExiste = taskRepository.findById(taskAtualizar.getId());
        if (usuarioExistente.isEmpty()) {
            mensagemDto.setMensagem("Usuário da tarefa não encontrado");
            mensagemDto.setSucesso(false);
            return mensagemDto;
        }
        if (taskExiste.isEmpty()) {
            mensagemDto.setMensagem("Tarefa não encontrada");
            mensagemDto.setSucesso(false);
            return mensagemDto;
        }
        TaskModel task = taskExiste.get();
        task.setNome(taskAtualizar.getNome());
        task.setDescricao(taskAtualizar.getDescricao());
        task.setAgendamento(taskAtualizar.getAgendamento());
        task.setStatus(taskAtualizar.getStatus());
        task.setUsuario(usuarioExistente.get());

        taskRepository.save(task);

        mensagemDto.setMensagem("Tarefa atualizada com sucesso");
        mensagemDto.setSucesso(true);
        return mensagemDto;
    }


    public MensagemDto deletarTask(Long taskId) {
        Optional<TaskModel> taskDeletar = taskRepository.findById(taskId);
        MensagemDto mensagemDto = new MensagemDto();
        if (taskDeletar.isPresent()) {
            taskRepository.delete(taskDeletar.get());
            mensagemDto.setSucesso(true);
            mensagemDto.setMensagem("Tarefa deletada");
            return mensagemDto;
        }
        mensagemDto.setSucesso(false);
        mensagemDto.setMensagem("Tarefa não encontrado");
        return mensagemDto;
    }
}
