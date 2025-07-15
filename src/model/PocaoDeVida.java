package model;

public class PocaoDeVida extends Item {
    private int cura;

    public PocaoDeVida() {
        this.nome = "Poção de Vida";
        this.cura = 30;
    }

    public int getCura() {
        return cura;
    }

    @Override
    public String toString() {
        return nome + " (+ " + cura + " HP)";
    }
}
