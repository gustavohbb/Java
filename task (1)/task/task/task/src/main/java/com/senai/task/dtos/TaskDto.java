package com.senai.task.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import javax.xml.transform.sax.SAXResult;
import java.util.Date;

public class TaskDto {
    @NotBlank
    private String nome;
    @NotBlank
    private  String descricao;
    @NotBlank
    private Date agendamento;
    private int status;
    @NotBlank
    private  String email;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
