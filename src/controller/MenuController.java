package controller;

import java.util.Scanner;

import model.Arqueiro;
import model.Desafio;
import model.Guerreiro;
import model.Heroi;
import model.Mago;
import service.Gerenciamento;

public class MenuController {

    private static Scanner sc = new Scanner(System.in);

    public static void exibirMenu() {
        int opcao;

        do {
            System.out.print("""
                    \n=== ARENA DE AVENTURAS ===
                    
                    1. Gerenciar Heróis 
                    2. Gerenciar Desafios
                    3. Participação em Desafios
                    4. Consultas e Relatórios
                    5. Sair
                    
                    Escolha uma opção: 
                    """);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> subMenuHeroi();
                case 2 -> subMenuDesafio();
                case 3 -> subMenuParticipacao();
                case 4 -> subMenuConsultas();
                case 5 -> System.out.println("\nObrigado por jogar! Até a próxima aventura!");
                default -> System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void subMenuHeroi() {
        int opcao;

        do {
            System.out.print("""
                    \n--- Gerenciar Heróis ---
                    
                    1. Criar Herói
                    2. Atualizar Herói (nível e vida)
                    3. Remover Herói
                    4. Voltar ao Menu Principal
                    
                    Escolha uma opção: 
                    """);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do Herói: ");
                    String nome = sc.nextLine();

                    System.out.println("Classe (1-Guerreiro, 2-Mago, 3-Arqueiro): ");
                    int classe = sc.nextInt();

                    System.out.print("Nível inicial: ");
                    int nivel = sc.nextInt();

                    System.out.print("Atributo específico (1-força, 2-inteligência, 3-destreza): ");
                    int atributo = sc.nextInt();

                    Heroi novo = switch (classe) {
                        case 1 -> new Guerreiro(nome, nivel, atributo);
                        case 2 -> new Mago(nome, nivel, atributo);
                        case 3 -> new Arqueiro(nome, nivel, atributo);
                        default -> null;
                    };

                    if (novo != null) {
                        Gerenciamento.criarHeroi(novo);
                    } else {
                        System.out.println("Classe inválida.");
                    }
                }

                case 2 -> {
                    System.out.print("Nome do herói para atualizar: ");
                    String nome = sc.nextLine();
                    Heroi heroi = Gerenciamento.buscarHeroi(nome);

                    if (heroi == null) {
                        System.out.println("Herói não encontrado.");
                        return;
                    }

                    System.out.print("Novo nível: ");
                    int novoNivel = sc.nextInt();
                    heroi.setNivel(novoNivel);

                    System.out.print("Nova vida atual: ");
                    int novaVida = sc.nextInt();
                    heroi.setVidaAtual(novaVida);

                    System.out.println("Herói atualizado com sucesso.");
                }

                case 3 -> {
                    System.out.print("Nome do herói para remover: ");
                    String nome = sc.nextLine();
                    Gerenciamento.removerHeroi(nome);
                }

                case 4 -> System.out.println("\nRetornando...");
                default -> System.out.println("Opção inválida. Tente Novamente.");
            }
        } while (opcao != 4);
    }

    private static void subMenuDesafio() {
        int opcao;

        do {
            System.out.print("""
                    \n--- Gerenciar Desafios ---
                    
                    1. Criar Desafio
                    2. Atualizar Desafio
                    3. Remover Desafio
                    4. Voltar ao Menu Principal
                    
                    Escolha uma opção: 
                    """);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do desafio: ");
                    String nome = sc.nextLine();

                    System.out.print("Dificuldade (1-Fácil, 2-Médio, 3-Difícil): ");
                    int dificuldade = sc.nextInt();

                    if (dificuldade < 1 || dificuldade > 3) {
                        System.out.println("Dificuldade inválida.");
                        break;
                    }

                    Desafio novo = new Desafio(nome, dificuldade);
                    Gerenciamento.criarDesafio(novo);
                }

                case 2 -> {
                    System.out.print("ID do desafio para atualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Nova dificuldade (1-3): ");
                    int dificuldade = sc.nextInt();

                    Gerenciamento.atualizarDesafio(id, nome, dificuldade);
                }

                case 3 -> {
                    System.out.print("ID do desafio para remover: ");
                    int id = sc.nextInt();
                    Gerenciamento.removerDesafio(id);
                }

                case 4 -> System.out.println("\nRetornando...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private static void subMenuParticipacao() {
        int opcao;
        do {
            System.out.print("""
                \n--- Participação em Desafios ---

                1. Adicionar Herói a Desafio
                2. Remover Herói de Desafio
                3. Iniciar Desafio
                4. Voltar

                Escolha: 
                """);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do herói: ");
                    String nome = sc.nextLine();

                    System.out.print("ID do desafio: ");
                    int id = sc.nextInt();

                    Gerenciamento.adicionarHeroiAoDesafio(nome, id);
                }
                case 2 -> {
                    System.out.print("Nome do herói: ");
                    String nome = sc.nextLine();

                    System.out.print("ID do desafio: ");
                    int id = sc.nextInt();

                    Gerenciamento.removerHeroiDoDesafio(nome, id);
                }
                case 3 -> {
                    System.out.print("ID do desafio para iniciar: ");
                    int id = sc.nextInt();
                    Gerenciamento.iniciarDesafio(id);
                }
                case 4 -> System.out.println("Retornando...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }


    private static void subMenuConsultas() {
        int opcao;

        do {
            System.out.print("""
                    \n--- Consultas e Relatórios ---
                    1. Listar Heróis
                    2. Listar Desafios
                    3. Buscar Herói por Nome
                    4. Voltar ao Menu Principal
                    
                    Escolha uma opção: 
                    """);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> Gerenciamento.listarHerois();
                case 2 -> Gerenciamento.listarDesafios();
                case 3 -> {
                    System.out.print("Digite o nome do herói: ");
                    String nome = sc.nextLine();
                    Heroi encontrado = Gerenciamento.buscarHeroi(nome);
                    if (encontrado != null) {
                        System.out.println("Herói encontrado: " + encontrado);
                    } else {
                        System.out.println("Herói não encontrado.");
                    }
                }
                case 4 -> System.out.println("Retornando...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }
}
