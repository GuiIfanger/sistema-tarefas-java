package org;

import java.time.LocalDate;

public class Tarefa{

    private int id;
    private String nome;
    private String descricao;
    private LocalDate dataEntrega;
    private StatusTarefa status;

    public Tarefa(int id, String nome, String descricao, LocalDate dataEntrega) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.status = StatusTarefa.PENDENTE;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
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

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public StatusTarefa getStatus() {
        return status;
    }
    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public void exibirDetalhes() {
        System.out.println("ID: " + id + " | Nome: " + nome + " | Descricao: " + descricao +
                " | Data de Entrega: " + dataEntrega + " | Status: " + status);
    }
}
