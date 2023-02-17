package service;
import model.Campeao;

public class CampeaoServiceImpl implements CampeaoService{

    @Override
    public void statusBase(Campeao campeao){
        if (campeao.getVidaBase() <= 0) {
            campeao.setVidaBase(0);
        }
        if (campeao.getNomeHeroi().equals("Garen")) {
            campeao.setAtaqueBase(20);
            campeao.setDefesaBase(50);
            campeao.setVidaBase(500);
            campeao.setNivel(campeao.getNivel());

        }
        if (campeao.getNomeHeroi().equals("Darius")) {
            campeao.setAtaqueBase(70);
            campeao.setDefesaBase(20);
            campeao.setVidaBase(400);
            campeao.setNivel(campeao.getNivel());
        }
    }

    @Override
    public void atacar(Campeao danoEfetuado, Campeao danoRecebido) { // Método para simular ataque a outro Campeão, considerando Defesa
           if (danoRecebido.getDefesaBase() >= danoEfetuado.getAtaqueBase()) {
               return;
           }
           danoRecebido.setVidaBase((danoRecebido.getVidaBase() + danoRecebido.getDefesaBase()) - danoEfetuado.getAtaqueBase());
    }

    @Override
    public void skillUm(Campeao danoEfetuadoSkillUm, Campeao danoRecebidoSkillUm, int valorAtaqueSkillUm) throws Exception { // Método para simular ataque utilizando Skill, considerando Defesa
        if (danoRecebidoSkillUm.getDefesaBase() >= valorAtaqueSkillUm + danoEfetuadoSkillUm.getAtaqueBase()) {
            return;
        }
            if (valorAtaqueSkillUm >= danoRecebidoSkillUm.getVidaBase()) {
                danoRecebidoSkillUm.setVidaBase(0);
                throw new Exception("Campeão derrotado");
            }
        danoRecebidoSkillUm.setVidaBase((danoRecebidoSkillUm.getVidaBase() + danoRecebidoSkillUm.getDefesaBase()) - valorAtaqueSkillUm - danoEfetuadoSkillUm.getAtaqueBase());
    }

    @Override
    public void skillDois(Campeao danoEfetuadoSkillDois, Campeao danoRecebidoSkillDois, int valorAtaqueSkillDois) { // Método para simular ataque utilizando Skill, considerando Defesa
        if (danoRecebidoSkillDois.getDefesaBase() >= valorAtaqueSkillDois + danoEfetuadoSkillDois.getAtaqueBase()) {
            return;
        }
        danoRecebidoSkillDois.setVidaBase((danoRecebidoSkillDois.getVidaBase() + danoRecebidoSkillDois.getDefesaBase()) - valorAtaqueSkillDois - danoEfetuadoSkillDois.getAtaqueBase());
        if (danoRecebidoSkillDois.getVidaBase() <= 0) {
            danoRecebidoSkillDois.setVidaBase(0);
        }
    }

    @Override
    public void skillTres(Campeao danoEfetuadoSkillTres, Campeao danoRecebidoSkillTres, int valorAtaqueSkillTres) { // Método para simular ataque utilizando Skill, considerando Defesa
        if (danoRecebidoSkillTres.getDefesaBase() >= valorAtaqueSkillTres + danoEfetuadoSkillTres.getAtaqueBase()) {
            return;
        }
        danoRecebidoSkillTres.setVidaBase((danoRecebidoSkillTres.getVidaBase() + danoRecebidoSkillTres.getDefesaBase()) - valorAtaqueSkillTres - danoEfetuadoSkillTres.getAtaqueBase());
    }

    @Override
    public void skillUltimate(Campeao campeao, Campeao danoEfetuadoSkillUltimate, Campeao danoRecebidoSkillUltimate, int valorAtaqueSkillUltimate) { // Método para simular ataque utilizando Ultimate, considerando Defesa
        if (campeao.getNivel() >= 5) {
            campeao.setUltimate(true);
            danoRecebidoSkillUltimate.setVidaBase((danoRecebidoSkillUltimate.getVidaBase() + danoRecebidoSkillUltimate.getDefesaBase()) - valorAtaqueSkillUltimate - danoEfetuadoSkillUltimate.getAtaqueBase());
            if (danoRecebidoSkillUltimate.getDefesaBase() >= danoEfetuadoSkillUltimate.getAtaqueBase() + danoEfetuadoSkillUltimate.getAtaqueBase()) {
                return;
            }
        }else {
            return;
        }
    }

    @Override
    public void feitico(Campeao danoEfetuadoFeitico, Campeao danoRecebidoFeitico, int valorAtaqueFeitico) { // Ignora Defesa
        danoEfetuadoFeitico.setAtaqueBase(danoEfetuadoFeitico.getAtaqueBase());
        danoRecebidoFeitico.setVidaBase(danoRecebidoFeitico.getVidaBase() - valorAtaqueFeitico);
    }
}
