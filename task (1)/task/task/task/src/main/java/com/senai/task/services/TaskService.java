package com.senai.task.services;

import com.senai.task.dtos.MensagemDto;
import com.senai.task.dtos.TaskDto;
import com.senai.task.models.TaskModel;
import com.senai.task.models.UserModel;
import com.senai.task.repositories.TaskRepository;
import com.senai.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    UserRepository userRepository;

    public List<TaskDto> obterTasks() {
        List<TaskModel> tasks = new ArrayList<>();
        List<TaskDto> tasksDto = new ArrayList<>();
        taskRepository.findAll();
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
        Optional<List<TaskModel>> taskExiste = taskRepository.findByEmail(task.getEmail());
        if (usuarioExistente.isPresent()) {
            if (taskExiste.isPresent()) {
                List<TaskModel> tasks = taskExiste.get();
                for (TaskModel tasksUsuario : tasks) {
                    if (tasksUsuario.getAgendamento().equals(task.getAgendamento())) {
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
        if (usuarioExistente.isPresent()) {
            if (taskExiste.isPresent()) {
                TaskModel task = taskExiste.get();
                mensagemDto.setMensagem("tarefa atualizada com sucesso");
                mensagemDto.setSucesso(true);
                TaskModel taskAtualizada = new TaskModel();
                taskAtualizada.setNome(taskAtualizar.getNome());
                taskAtualizada.setDescricao(taskAtualizar.getDescricao());
                taskAtualizada.setAgendamento(taskAtualizar.getAgendamento());
                taskAtualizada.setStatus(taskAtualizar.getStatus());
                taskAtualizada.setUsuario(usuarioExistente.get());
                taskRepository.save(taskAtualizada);
                return mensagemDto;
            }
            mensagemDto.setMensagem("Tarefa não encontrada");
            mensagemDto.setSucesso(false);
            return mensagemDto;
        }
        mensagemDto.setMensagem("Usuário da tarefa não encontrado");
        mensagemDto.setSucesso(false);
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
