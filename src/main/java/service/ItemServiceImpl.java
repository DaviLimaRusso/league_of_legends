package service;
import model.Campeao;
import model.Item;

public class ItemServiceImpl implements ItemService{
    @Override
    public void dano(Item item, Campeao campeao) {
        campeao.setAtaqueBase(item.setAtaque(item.getAtaque() + campeao.getAtaqueBase()));
    }

    @Override
    public void defesa(Item item, Campeao campeao) {
        campeao.setDefesaBase(item.setDefesa(item.getDefesa() + campeao.getDefesaBase()));
    }

    @Override
    public void vida(Item item, Campeao campeao) {
        campeao.setVidaBase(item.setVida(item.getVida() + campeao.getVidaBase()));
    }
}
