package model;

public class Mago extends Heroi {
    private int inteligencia;

    public Mago(String nome, int nivel, int inteligencia) {
        super(nome, nivel, "Mago");
        // impede que alguem crie mago com inteligencia negativa ou 0
        if (inteligencia <= 0) throw new IllegalArgumentException("Inteligência deve ser maior que 0.");
        this.inteligencia = inteligencia;
    }

    @Override
    public int atacar() {
        return inteligencia * getNivel() + 10;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [Inteligência: %d]", inteligencia);
    }
}
