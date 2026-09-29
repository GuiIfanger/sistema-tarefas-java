package org.example;

import org.Gerenciamento;
import org.StatusTarefa;
import org.Tarefa;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Gerenciamento g = new Gerenciamento();

        int opcao;

        do {
            System.out.println("----- SISTEMA DE GERENCIAMENTO DE TAREFAS ----- \n1.Adicionar Tarefa \n2.Visualizar Tarefas \n3.Excluir Tarefa \n4.Atualizar Status da Tarefa \n0.Sair \nEscolha uma opcao:");
            opcao = scan.nextInt();
            scan.nextLine();

            if (opcao == 1) {
                System.out.println("Digite o id da tarefa: ");
                int id = scan.nextInt();
                scan.nextLine();
                System.out.println("Digite o nome da tarefa: ");
                String nome = scan.nextLine();
                System.out.println("Digite o descricao da tarefa: ");
                String descricao = scan.nextLine();
                System.out.println("Digite a Data de Entrega da tarefa (AAAA-MM-DD): ");
                LocalDate dataEntrega = LocalDate.parse(scan.nextLine());

                Tarefa novaTarefa = new Tarefa(id, nome, descricao, dataEntrega);
                g.adicionarTarefa(novaTarefa);

                System.out.println("Tarefa adicionada com sucesso!");
            }
            else if (opcao == 2) {
                System.out.println("Como deseja visualizar tarefas \n1.Filtrar por Status \n2.Ver todas as tarefas");
                int opcaoVisualizacao = scan.nextInt();
                scan.nextLine();

                if (opcaoVisualizacao == 1) {
                    System.out.println("Qual Status deseja visualizar \n1.PENDENTE \n2.EM ANDAMENTO \n3.CONCLUIDA");
                    int opcaoStatus = scan.nextInt();
                    scan.nextLine();
                    if (opcaoStatus == 1) {
                        g.listarTarefasPorStatus(StatusTarefa.PENDENTE);
                    }
                    else  if (opcaoStatus == 2) {
                        g.listarTarefasPorStatus(StatusTarefa.EM_ANDAMENTO);
                    }
                    else  if (opcaoStatus == 3) {
                        g.listarTarefasPorStatus(StatusTarefa.CONCLUIDA);
                    }
                }
                else  if (opcaoVisualizacao == 2) {
                    g.listarTarefas();
                }
            }
            else if (opcao == 3) {
                System.out.println("Qual id da tarefa que deseja excluir? ");
                int id = scan.nextInt();
                scan.nextLine();
                g.removeTarefa(id);
            }
            else if (opcao == 4) {
                System.out.println("Qual o ID da tarefa que deseja atualizar? ");
                int id = scan.nextInt();
                scan.nextLine(); // Limpa o buffer do teclado

                System.out.println("Escolha o novo status:");
                System.out.println("1. PENDENTE");
                System.out.println("2. EM_ANDAMENTO");
                System.out.println("3. CONCLUIDA");
                int escolhaStatus = scan.nextInt();
                scan.nextLine();

                StatusTarefa novoStatus = null;

                if (escolhaStatus == 1) {
                    novoStatus = StatusTarefa.PENDENTE;
                } else if (escolhaStatus == 2) {
                    novoStatus = StatusTarefa.EM_ANDAMENTO;
                } else if (escolhaStatus == 3) {
                    novoStatus = StatusTarefa.CONCLUIDA;
                }

                if (novoStatus != null) {
                    Tarefa tarefaAtualizada = g.atualizarStatusTarefa(id, novoStatus);

                    if (tarefaAtualizada != null) {
                        System.out.println("Status da tarefa atualizado com sucesso!");
                    } else {
                        System.out.println("Erro: Tarefa com ID " + id + " não encontrada.");
                    }
                } else {
                    System.out.println("Opção de status inválida!");
                }
            }


        } while (opcao != 0);
    }
}