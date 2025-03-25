package com.senai.task.services;

import com.senai.task.dtos.MensagemDto;
import com.senai.task.dtos.UserDto;
import com.senai.task.models.UserModel;
import com.senai.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<UserDto> obterUsuarios() {
        List<UserModel> listaModel = new ArrayList<>();
        List<UserDto> listaDto = new ArrayList<>();
        listaModel = repository.findAll();
        for (UserModel usuario : listaModel) {
            UserDto usuarioTransferido = new UserDto();
            usuarioTransferido.setNome(usuario.getNome());
            usuarioTransferido.setEmail(usuario.getEmail());
            listaDto.add(usuarioTransferido);
        }
        return listaDto;
    }

    public MensagemDto inserirUsuario(UserDto userInserir) {
        Optional<UserModel> usuarioExistente = repository.findByEmail(userInserir.getEmail());
        UserModel user = new UserModel();
        MensagemDto  mensagemDto = new MensagemDto();
        if (usuarioExistente.isPresent()) {
            mensagemDto.setMensagem("Usuario ja cadastrado");
            mensagemDto.setSucesso(false);
            return mensagemDto;
        }
        user.setEmail(userInserir.getEmail());
        user.setNome(userInserir.getNome());
        repository.save(user);
        mensagemDto.setMensagem("Usuario Cadastrado Com Sucesso");
        mensagemDto.setSucesso(true);
        return mensagemDto;
    }

    public MensagemDto atualizarUsuario(UserDto userAtualizar) {
        Optional<UserModel> usuarioExistente = repository.findByEmail(userAtualizar.getEmail());
        UserModel user = new UserModel();
        MensagemDto mensagemDto = new MensagemDto();
        if (usuarioExistente.isPresent()) {
            user.setNome(userAtualizar.getNome());
            user.setEmail(userAtualizar.getNome());
            repository.save(user);
            mensagemDto.setMensagem("Usuario atualizado");
            mensagemDto.setSucesso(true);
            return mensagemDto;
        }
        mensagemDto.setMensagem("Usuario não encontrado");
        mensagemDto.setSucesso(false);
        return mensagemDto;
    }

    public UserDto obterUsuario(String email) {
        Optional<UserModel> usuarioExistente = repository.findByEmail(email);
        UserModel user = new UserModel();
        UserDto userResposta = new UserDto();
        if (usuarioExistente.isPresent()) {
           user = usuarioExistente.get();
           userResposta.setNome(user.getNome());
           userResposta.setEmail(user.getEmail());
           return userResposta;
        }
        return userResposta;
    }
    public MensagemDto deletarUsuario(String email) {
        Optional<UserModel> usuarioDeletar = repository.findByEmail(email);
        MensagemDto mensagemDto = new MensagemDto();
        if (usuarioDeletar.isPresent()) {
            repository.delete(usuarioDeletar.get());
            mensagemDto.setSucesso(true);
            mensagemDto.setMensagem("usuario deletado");
            return mensagemDto;
        }
        mensagemDto.setSucesso(false);
        mensagemDto.setMensagem("Usuario não encontrado");
        return mensagemDto;
    }
}
