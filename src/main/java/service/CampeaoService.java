package service;
import model.Campeao;

public interface CampeaoService {

    void statusBase (Campeao campeao);
    void atacar(Campeao danoEfetuado, Campeao danoRecebido);
    void skillUm (Campeao danoEfetuadoSkillUm, Campeao danoRecebidoSkillUm, int valorAtaqueSkillUm) throws Exception;
    void skillDois (Campeao danoEfetuadoSkillDois, Campeao danoRecebidoSkillDois, int valorAtaqueSkillDois);
    void skillTres (Campeao danoEfetuadoSkillTres, Campeao danoRecebidoSkillTres, int valorAtaqueSkillTres);
    void skillUltimate (Campeao campeao, Campeao danoEfetuadoSkillUltimate, Campeao danoRecebidoSkillUltimate, int valorAtaqueSkillUltimate) throws Exception;
    void feitico (Campeao danoEfetuadoFeitico, Campeao danoRecebidoFeitico, int valorAtaqueFeitico);

}
