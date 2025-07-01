package model;

import java.util.ArrayList;

public abstract class Heroi {
	private String nome;
    private int nivel;
    private int vidaAtual;
    private int vidaMaxima;
    private int experiencia;
    private boolean statusVivo;
    private ArrayList<Item> inventario;
    
    public Heroi (String nome, int nivel) {
    	this.nome = nome;
    	this.nivel = nivel;
    	this.vidaMaxima = nivel * 100;
    	this.vidaAtual = this.vidaMaxima;
    	this.experiencia = 0;
    	this.statusVivo = true;
        this.inventario = new ArrayList<>();
    }
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getNivel() {
		return nivel;
	}



	public void setNivel(int nivel) {
		this.nivel = nivel;
	}



	public int getVidaAtual() {
		return vidaAtual;
	}



	public void setVidaAtual(int vidaAtual) {
		this.vidaAtual = vidaAtual;
	}


	// Método de Ataque (abstrato)
	public abstract void ataque();
	
	// Método para aplicar redução de vida e atualizar status de vivo.
	public int receberDano() {
		return 0;
	}
	
	// Método para agregar experiência, checar subida de nível automática e restaurar vida.
	public int ganharExperiencia() {
		return 0;
	}

	// Método para adicionar item ao inventário e registrar descrição.
	
	
	// Método para iterar sobre a lista de itens e exibir cada um.
	
	@Override
	public String toString() {
		return "heroi [nome=" + nome + ", nivel=" + nivel + ", vidaAtual=" + vidaAtual + ", vidaMaxima=" + vidaMaxima
				+ ", experiencia=" + experiencia + ", statusVivo=" + statusVivo + ", inventario=" + inventario + "]";
	}
}
