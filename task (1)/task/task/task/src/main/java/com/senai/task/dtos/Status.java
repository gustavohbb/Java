package com.senai.task.dtos;

public enum Status {
    EM_ABERTO(1),
    EM_ANDAMENTO(2),
    CONCLUIDO(3),
    CANCELADO(4);

    private final int codigo;

    Status(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Status fromCodigo(int codigo) {
        for (Status status : Status.values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status inválido: " + codigo);
    }
}
