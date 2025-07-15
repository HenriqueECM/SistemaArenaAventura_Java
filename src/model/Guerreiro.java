package model;

public class Guerreiro extends Heroi {
    private int forca;

    public Guerreiro(String nome, int nivel, int forca) {
        super(nome, nivel, "Guerreiro");
        if (forca <= 0) throw new IllegalArgumentException("Força deve ser maior que 0.");
        this.forca = forca;
    }

    @Override
    public int atacar() {
        return forca * getNivel();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [Força: %d]", forca);
    }
}
