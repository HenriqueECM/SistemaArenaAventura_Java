package model;

import java.util.ArrayList;
import java.util.List;

public class Desafio {
    private static int contador = 1;
    private int id;
    private String nome;
    private int dificuldade; // 1 a 3
    private List<Heroi> participantes;

    public Desafio(String nome, int dificuldade) {
        this.id = contador++;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.participantes = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getDificuldade() { return dificuldade; }
    public void setDificuldade(int dificuldade) { this.dificuldade = dificuldade; }
    public List<Heroi> getParticipantes() { return participantes; }

    public void adicionarHeroi(Heroi heroi) {
        if (!participantes.contains(heroi)) {
            participantes.add(heroi);
            System.out.println("Herói adicionado ao desafio.");
        } else {
            System.out.println("Esse herói já está no desafio.");
        }
    }

    public void removerHeroi(Heroi heroi) {
        if (participantes.remove(heroi)) {
            System.out.println("Herói removido do desafio.");
        } else {
            System.out.println("Herói não encontrado no desafio.");
        }
    }

    public void iniciar() {
        System.out.println("\n--- Iniciando Desafio: " + nome + " ---");
        if (participantes.isEmpty()) {
            System.out.println("Nenhum herói no desafio!");
            return;
        }

        for (Heroi h : participantes) {
            boolean sucesso = h.getNivel() >= dificuldade * 2;
            System.out.println(h.getNome() + " " + (sucesso ? "venceu!" : "falhou."));
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + nome + " | Dificuldade: " + dificuldade + " | Participantes: " + participantes.size();
    }
}
