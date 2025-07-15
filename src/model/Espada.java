package model;

public class Espada extends Item {
    private int danoBonus;

    public Espada() {
        this.nome = "Espada";
        this.danoBonus = 7;
    }

    public int getDanoBonus() {
        return danoBonus;
    }

    @Override
    public String toString() {
        return nome + " (+ " + danoBonus + " dano)";
    }
}
