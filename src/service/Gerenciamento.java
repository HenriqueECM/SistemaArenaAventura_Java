package service;

import java.util.ArrayList;
import java.util.Scanner;

import model.Desafio;
import model.Heroi;

public class Gerenciamento {
	
	private static ArrayList<Heroi> listaHerois = new ArrayList<>();
	private static ArrayList<Desafio> listaDesafios = new ArrayList<>();
	
	// ------------------ CRUD HEROI ------------------ // 
	public static void criarHeroi (Heroi heroi) {
        for (Heroi h : listaHerois) {
            if (h.getNome().equalsIgnoreCase(heroi.getNome())) {
                System.out.println("\nJá existe um herói com esse nome.");
                return;
            }
        }
        listaHerois.add(heroi);
        System.out.println("\nHerói '" + heroi.getNome() + "' criado com sucesso!");
    }
	
	public static void removerHeroi(String nome) {
        Heroi encontrado = null;
        for (Heroi h : listaHerois) {
            if (h.getNome().equalsIgnoreCase(nome)) {
                encontrado = h;
                break;
            }
        }
        if (encontrado != null) {
            listaHerois.remove(encontrado);
            System.out.println("Herói removido com sucesso.");
        } else {
            System.out.println("Herói não encontrado.");
        }
    }
	
	public static Heroi buscarHeroi(String nome) {
        for (Heroi h : listaHerois) {
            if (h.getNome().equalsIgnoreCase(nome)) {
                return h;
            }
        }
        return null;
    }
	
	public static void listarHerois() {
        if (listaHerois.isEmpty()) {
            System.out.println("Nenhum herói cadastrado.");
        } else {
            for (Heroi h : listaHerois) {
                System.out.println(h);
            }
        }
    }
	
	
	// ------------------ CRUD DESAFIO ------------------ //
	public static void criarDesafio(Desafio desafio) {
        for (Desafio d : listaDesafios) {
            if (d.getNome().equalsIgnoreCase(desafio.getNome())) {
                System.out.println("Nome de desafio já existe.");
                return;
            }
        }
        listaDesafios.add(desafio);
        System.out.println("Desafio '" + desafio.getNome() + "' criado com ID " + desafio.getId());
    }

    public static void listarDesafios() {
        if (listaDesafios.isEmpty()) {
            System.out.println("Nenhum desafio criado.");
            return;
        }
        for (Desafio d : listaDesafios) {
            System.out.println(d);
        }
    }

    public static void removerDesafio(int id) {
        boolean removido = listaDesafios.removeIf(d -> d.getId() == id);
        if (removido)
            System.out.println("Desafio removido com sucesso.");
        else
            System.out.println("Desafio não encontrado.");
    }

    public static Desafio buscarDesafio(int id) {
        for (Desafio d : listaDesafios) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    public static void atualizarDesafio(int id, String novoNome, int novaDificuldade) {
        Desafio d = buscarDesafio(id);
        if (d != null) {
            d.setNome(novoNome);
            d.setDificuldade(novaDificuldade);
            System.out.println("Desafio atualizado.");
        } else {
            System.out.println("Desafio não encontrado.");
        }
    }
    
    public static void adicionarHeroiAoDesafio(String nomeHeroi, int idDesafio) {
        Heroi h = buscarHeroi(nomeHeroi);
        Desafio d = buscarDesafio(idDesafio);

        if (h == null || d == null) {
            System.out.println("Herói ou desafio não encontrado.");
            return;
        }

        d.adicionarHeroi(h);
    }

    public static void removerHeroiDoDesafio(String nomeHeroi, int idDesafio) {
        Heroi h = buscarHeroi(nomeHeroi);
        Desafio d = buscarDesafio(idDesafio);

        if (h == null || d == null) {
            System.out.println("Herói ou desafio não encontrado.");
            return;
        }

        d.removerHeroi(h);
    }

    public static void iniciarDesafio(int id) {
        Desafio d = buscarDesafio(id);
        if (d != null) {
            d.iniciar();
        } else {
            System.out.println("Desafio não encontrado.");
        }
    }

}
