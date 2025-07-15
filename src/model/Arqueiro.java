package model;

public class Arqueiro extends Heroi {
    private int destreza;

    public Arqueiro(String nome, int nivel, int destreza) {
        super(nome, nivel, "Arqueiro");
        if (destreza <= 0) throw new IllegalArgumentException("Destreza deve ser maior que 0.");
        this.destreza = destreza;
    }

    @Override
    public int atacar() {
        return destreza * getNivel() + 5;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [Destreza: %d]", destreza);
    }
}
