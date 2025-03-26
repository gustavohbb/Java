package com.senai.task.models;

import com.senai.task.dtos.Status;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tarefas")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Date agendamento;
    @Column(nullable = false)
    private Status status;
    @ManyToOne()
    @JoinColumn(name = "id_usuario", referencedColumnName = "email")
    private UserModel email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Date agendamento) {
        this.agendamento = agendamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserModel getUsuario() {
        return email;
    }

    public void setUsuario(UserModel usuario) {
        this.email = usuario;
    }
}
