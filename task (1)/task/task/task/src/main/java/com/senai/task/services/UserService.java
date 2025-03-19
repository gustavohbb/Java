package com.senai.task.services;

import com.senai.task.dtos.UserDto;
import com.senai.task.models.UserModel;
import com.senai.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
