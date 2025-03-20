package com.senai.task.services;

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

    public boolean inserirusuario(UserDto userInserir) {
        Optional<UserModel> usuarioExistente = repository.findByEmail(userInserir.getEmail());
        UserModel user = new UserModel();
        if (usuarioExistente.isPresent()) {
            return false;
        }
        user.setEmail(userInserir.getEmail());
        user.setNome(userInserir.getNome());
        repository.save(user);
        return true;
    }

    public boolean atualizarUsuario(UserDto userAtualizar) {
        Optional<UserModel> usuarioExistente = repository.findByEmail(userAtualizar.getEmail());
        UserModel user = new UserModel();
        if (usuarioExistente.isPresent()) {
            user.setNome(userAtualizar.getNome());
            user.setEmail(userAtualizar.getNome());
            repository.save(user);
            return true;
        }
        return false;
    }


}
