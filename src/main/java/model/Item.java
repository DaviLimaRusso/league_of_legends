package model;

public class Item {

    private String nomeItem;
    private int ataque;
    private int defesa;
    private int vida;

    public Item(String nomeItem, int ataque, int defesa, int vida) {
        this.nomeItem = nomeItem;
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getAtaque() {
        return ataque;
    }

    public int setAtaque(int ataque) {
        this.ataque = ataque;
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int setDefesa(int defesa) {
        this.defesa = defesa;
        return defesa;
    }

    public int getVida() {
        return vida;
    }

    public int setVida(int vida) {
        this.vida = vida;
        return vida;
    }
}
