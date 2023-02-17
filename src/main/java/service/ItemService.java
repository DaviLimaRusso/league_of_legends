package service;
import model.Campeao;
import model.Item;

public interface ItemService {

    void dano (Item item, Campeao campeao);
    void defesa (Item item, Campeao campeao);
    void vida (Item item, Campeao campeao);
}
