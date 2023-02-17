package service;

import model.Campeao;
import model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CampeaoServiceTest {

    CampeaoService campeaoService;
    ItemService itemService;

    @BeforeEach
    public void setup() {
        campeaoService = new CampeaoServiceImpl();
        itemService = new ItemServiceImpl();
    }


    @Test
    @DisplayName("Validar Nível do Campeão na partida")
    public void validarNivelDoCampeaoNaPartida() {
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 4);

        // Quando
        campeaoService.statusBase(garen);

        // Então
        Assertions.assertEquals(4, garen.getNivel());
    }

    @Test
    @DisplayName("Validar atributos base por Campeão")
    public void validarAtributosBasePorCampeao() {
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 4);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);

        // Quando
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);

        // Então
        Assertions.assertEquals(20, garen.getAtaqueBase());
        Assertions.assertEquals(70, darius.getAtaqueBase());
        Assertions.assertEquals(50, garen.getDefesaBase());
        Assertions.assertEquals(20, darius.getDefesaBase());
        Assertions.assertEquals(500, garen.getVidaBase());
        Assertions.assertEquals(400, darius.getVidaBase());
    }

    @Test
    @DisplayName("Validar ataque ao Campeão")
    public void validarAtaqueAoCampeao() {
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 4);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);

        // Quando
        campeaoService.atacar(darius, garen);
        campeaoService.atacar(darius, garen);

        // Então
        Assertions.assertEquals(460, garen.getVidaBase());
    }

    @Test
    @DisplayName("Adicionar item ao Campeão")
    public void adicionarItemAoCampeao() {
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 4);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);
        Item cuteloNegro = new Item("Cutelo Negro", 40, 30, 100);
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);


        // Quando
        garen.setItem(cuteloNegro);
        itemService.dano(cuteloNegro, garen);

        // Então
        Assertions.assertEquals(60, garen.getAtaqueBase());
    }

    @Test
    @DisplayName("Deve atacar e usar feitiço")
    public void deveAtacarEUsarFeitico() {
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 4);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);

        // Quando
        campeaoService.feitico(garen, darius, 20);

        // Então
        Assertions.assertEquals(380, darius.getVidaBase());
    }

    @Test
    @DisplayName("Deve atacar utilizando skills")
    public void deveAtacarUtilizandoSkills() throws Exception{
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 4);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);

        // Quando
        campeaoService.skillUm(garen, darius, 40);
        campeaoService.skillDois(garen, darius, 60);
        campeaoService.skillTres(garen, darius, 100);

        // Então
        Assertions.assertEquals(200, darius.getVidaBase());
    }

    @Test
    @DisplayName("Validar atributos do item")
    public void validarAtributosItem() {
        // Dado
        Item cuteloNegro = new Item("Cutelo Negro", 40, 30, 100);

        // Então
        Assertions.assertEquals("Cutelo Negro", cuteloNegro.getNomeItem());
        Assertions.assertEquals(40, cuteloNegro.getAtaque());
        Assertions.assertEquals(30, cuteloNegro.getDefesa());
        Assertions.assertEquals(100, cuteloNegro.getVida());
    }

    @Test
    @DisplayName("Validando aumento de atributos com item adicionado ao Campeão")
    public void validandoAumentoDeAtributosComItem() {
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 4);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);
        Item cuteloNegro = new Item("Cutelo Negro", 40, 30, 100);
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);


        // Quando
        garen.setItem(cuteloNegro);
        itemService.dano(cuteloNegro, garen);
        itemService.defesa(cuteloNegro, garen);
        itemService.vida(cuteloNegro, garen);

        // Então
        Assertions.assertEquals(60, garen.getAtaqueBase());
        Assertions.assertEquals(80, garen.getDefesaBase());
        Assertions.assertEquals(600, garen.getVidaBase());
    }

    @Test
    @DisplayName("Validar ataque com item aumentando o dano do Campeão")
    public void validarAtaqueComItemAumentandoODano() {
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 4);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);
        Item cuteloNegro = new Item("Cutelo Negro", 40, 30, 100);
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);

        // Quando
        garen.setItem(cuteloNegro);
        itemService.dano(cuteloNegro, garen);
        itemService.defesa(cuteloNegro, garen);
        itemService.vida(cuteloNegro, garen);
        campeaoService.atacar(garen, darius);

        // Então
        Assertions.assertEquals(360, darius.getVidaBase());
    }


    @Test // Teste de exception
    @DisplayName("Validar exception ao matar oponente com skill")
    public void validarExceptionAoMatarOponenteComSkill() {
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 4);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);

        // Então

        Assertions.assertThrows(Exception.class, () -> {
            campeaoService.skillUm(darius, garen, 800);
        });
    }

    @Test
    @DisplayName("Validar ultimate quando Campeão está lvl 5")
    public void validarUltimate() throws Exception {
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 5);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);

        // Quando
        campeaoService.skillUltimate(garen, garen, darius, 100);

        // Então
        Assertions.assertEquals(300, darius.getVidaBase());
    }

    @Test
    @DisplayName("Validar ultimate false se o Campeão não estiver lvl 5")
    public void validarUltimateFalseSeOCampeaoNaoEstiverLvlCinco() throws Exception{
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 4);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);

        // Quando
        campeaoService.skillUltimate(garen, garen, darius, 900);

        // Então
        Assertions.assertEquals(400, darius.getVidaBase());
        Assertions.assertFalse(garen.isUltimate());
    }

    @Test
    @DisplayName("Validar Campeão derrotado")
    public void validarCampeaoDerrotado() {
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 5);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);

        // Quando
        campeaoService.skillDois(garen, darius, 900);

        // Então
        Assertions.assertEquals(0, darius.getVidaBase());
    }

    @Test
    @DisplayName("Não deve tomar dano se tiver mais defesa do que o ataque do oponente")
    public void naoDeveTomarDanoSeTiverMaisDefesa() {
        // Dado
        Campeao garen = new Campeao("Garen", 1.90f, "Solo", 5);
        Campeao darius = new Campeao("Darius", 1.90f, "Solo", 4);
        campeaoService.statusBase(garen);
        campeaoService.statusBase(darius);

        // Quando
        campeaoService.atacar(garen, darius);

        // Então
        Assertions.assertEquals(400, darius.getVidaBase());
    }
}
