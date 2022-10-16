package core.interactors;

import core.entities.Processo;
import core.interfaces.DataLogicInterface;

public class CriarProcesso {
    private DataLogicInterface dataLogicInterface;
    public CriarProcesso(DataLogicInterface dataLogicInterface){
        this.dataLogicInterface = dataLogicInterface;
    }

    public Processo create(Processo novoProcesso){
        dataLogicInterface.create(novoProcesso);
        return novoProcesso;
    }
}
