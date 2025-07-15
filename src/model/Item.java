package model;

public abstract class Item {
    protected String nome;

    public String getNome() {
        return nome;
    }

    public abstract String toString();
}
