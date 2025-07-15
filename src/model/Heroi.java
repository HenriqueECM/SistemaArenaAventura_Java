package model;

import java.util.ArrayList;

public abstract class Heroi {
    private String nome;
    private String classe;
    private int nivel;
    private int vidaAtual;
    private int vidaMaxima;
    private int experiencia;
    private boolean vivo;
    private ArrayList<Item> inventario = new ArrayList<>();

    public Heroi(String nome, int nivel, String classe) {
        this.nome = nome;
        this.nivel = nivel;
        this.classe = classe;
        this.vidaMaxima = nivel * 100;
        this.vidaAtual = vidaMaxima;
        this.experiencia = 0;
        this.vivo = true;
    }

    public abstract int atacar();

    public void receberDano(int dano) {
        vidaAtual -= dano;
        if (vidaAtual <= 0) {
            vidaAtual = 0;
            vivo = false;
        }
    }

    public void ganharExperiencia(int xp) {
        experiencia += xp;
        while (experiencia >= nivel * 100) {
            experiencia -= nivel * 100;
            nivel++;
            vidaMaxima = nivel * 100;
            vidaAtual = vidaMaxima;
        }
    }

    public void adicionarItem(Item item) {
        inventario.add(item);
    }

    public void listarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("- Inventário vazio.");
        } else {
            for (Item item : inventario) {
                System.out.println("- " + item);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s (Classe: %s) | Nível: %d | Vida: %d/%d | XP: %d | Itens: %d",
                nome, classe, nivel, vidaAtual, vidaMaxima, experiencia, inventario.size());
    }

    // Getters
    public String getNome() { 
    	return nome; 
    	}
    
    public int getNivel() { 
    	return nivel; 
    	}
    
    public int getVidaAtual() { 
    	return vidaAtual; 
    	}
    
    public boolean isVivo() { 
    	return vivo; 
    	}
    
    public String getClasse() { 
    	return classe; 
    	}
    
    public int getExperiencia() { 
    	return experiencia; 
    	}
    
    public ArrayList<Item> getInventario() { 
    	return inventario; 
    	}

    // Setters limitados
    public void setNivel(int nivel) {
        this.nivel = nivel;
        this.vidaMaxima = nivel * 100;
    }

    public void setVidaAtual(int vida) {
        this.vidaAtual = Math.min(vida, vidaMaxima);
        this.vivo = vidaAtual > 0;
    }
}
