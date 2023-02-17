package model;

public class Campeao {

    private String nomeHeroi;
    private float altura;
    private String funcao;
    private int vidaBase;
    private int ataqueBase;
    private int defesaBase;
    private int nivel;
    private boolean ultimate;
    private Item item;

    public Campeao(String nomeHeroi, float altura, String funcao, int nivel) {
        this.nomeHeroi = nomeHeroi;
        this.altura = altura;
        this.funcao = funcao;
        this.vidaBase = 0;
        this.ataqueBase = 0;
        this.defesaBase = 0;
        this.nivel = nivel;
        this.ultimate = false;
        this.item = null;
    }

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(String nomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getVidaBase() {
        return vidaBase;
    }

    public void setVidaBase(int vidaBase) {
        this.vidaBase = vidaBase;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public void setAtaqueBase(int ataqueBase) {
        this.ataqueBase = ataqueBase;
    }

    public int getDefesaBase() {
        return defesaBase;
    }

    public void setDefesaBase(int defesaBase) {
        this.defesaBase = defesaBase;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isUltimate() {
        return ultimate;
    }

    public void setUltimate(boolean ultimate) {
        this.ultimate = ultimate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
