package controller;

import java.util.Scanner;

public class MenuController {

    private static Scanner sc = new Scanner(System.in);

    // Método público para chamar o menu de fora (por exemplo, do Main)
    public static void exibirMenu() {
        int opcao;

        do {
        	System.out.print("""
        			=== ARENA DE AVENTURAS ===
        			
        			1. Gerenciar Heróis 
        			2. Gerenciar Desafios
        			3. Participação em Desafios
        			4. Consultas e Relatórios
        			5. Sair
        			
        			Escolha uma opção: 
        			""");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    subMenuHeroi();
                    break;
                case 2:
                    subMenuDesafio();
                    break;
                case 3:
                    subMenuParticipacao();
                    break;
                case 4:
                    subMenuConsultas();
                    break;
                case 5:
                    System.out.println("\nObrigado por jogar! Até a próxima aventura!");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
            System.out.println(); // linha em branco
        } while (opcao != 5);
    }
    
    private static void subMenuHeroi() {
		int opcao;
		
		do {
			System.out.print("""
					--- Gerenciar Heróis ---
					
					1. Criar Herói
					2. Atualizar Herói
					3. Remover Herói
					4. Voltar ao Menu Principal
					
					Escolha uma opção: 
					""");
			opcao = sc.nextInt();
			
			switch (opcao) {
				case 1: 
				case 2:
				case 3:
				case 4: 
					System.out.println("\nRetornando.."); 
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
			}
		} while(opcao != 4);
	}
    
    private static void subMenuDesafio() {
    	int opcao;
    	
    	do {
			System.out.print("""
					--- Gerenciar Desafios ---
					
					1. Criar Desafio
					2. Atualizar Desafio
					3. Remover Desafio
					4. Voltar ao Menu Principal
					
					Escolha uma opção: 
					""");
			opcao = sc.nextInt();
			
			switch (opcao) {
				case 1: 
				case 2:
				case 3:
				case 4: 
					System.out.println("\nRetornando.."); 
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
			}
		} while(opcao != 4);
	}
    
    private static void subMenuParticipacao() {
    	int opcao;
    	
    	do {
			System.out.print("""
					--- Participação em Desafios ---
					
					1. Adicionar Herói a Desafio
					2. Remover Herói de Desafio
					3. Remover Desafio
					4. Iniciar Desafio
					5. Voltar ao Menu Principal
					
					Escolha uma opção: 
					""");
			opcao = sc.nextInt();
			
			switch (opcao) {
				case 1: 
				case 2:
				case 3:
				case 4:
				case 5:
					System.out.println("\nRetornando.."); 
					break;
					
				default:
					System.out.println("Opção inválida! Tente novamente.");
			}
		} while(opcao != 5);
	}

	private static void subMenuConsultas() {
		int opcao;
		
		do {
			System.out.print("""
					--- Consultas e Relatórios ---
					1. Listar Heróis
					2. Listar Desafios
					3. Buscar Herói por Nome
					4. Exibir Inventário de Herói
					5. Agrupar Heróis por Nível
					6. Agrupar Desafios por Dificuldade
					7. Voltar ao Menu Principal
					
					Escolha uma opção: 
					""");
			opcao = sc.nextInt();
			
			switch (opcao) {
				case 1: 
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
					System.out.println("\nRetornando.."); 
					break;
					
				default:
					System.out.println("Opção inválida! Tente novamente.");
			}
		} while (opcao != 7);
	}
}
