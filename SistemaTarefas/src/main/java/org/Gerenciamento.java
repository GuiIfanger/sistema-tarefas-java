package org;

import java.util.ArrayList;
import java.util.List;

public class Gerenciamento {

        private List<Tarefa> tarefas = new ArrayList<>();

        public void adicionarTarefa(Tarefa tarefa){
            tarefas.add(tarefa);
        }

        public void listarTarefas(){
            for (Tarefa tarefa : tarefas) {
                tarefa.exibirDetalhes();
            }
        }

        public void listarTarefasPorStatus(StatusTarefa statusDesejado) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus() == statusDesejado) {
                tarefa.exibirDetalhes();
            }
        }
        }

        public void removeTarefa(int id){
            tarefas.removeIf(tarefa -> tarefa.getId() == id);
        }

        public Tarefa buscarTarefa(int id){
            for (Tarefa tarefa : tarefas) {
                if (tarefa.getId() == id) {
                    return tarefa;
                }
            }
            return null;
        }

    public Tarefa atualizarStatusTarefa(int id, StatusTarefa novoStatus) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefa.setStatus(novoStatus);
                return tarefa;
            }
        }
        return null;
    }




}
