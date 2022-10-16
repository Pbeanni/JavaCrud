package core.interactors;

import core.entities.Processo;
import core.interfaces.DataLogicInterface;
import org.bson.types.ObjectId;

public class AtualizarProcesso {
    private DataLogicInterface dataLogicInterface;
    public AtualizarProcesso(DataLogicInterface dataLogicInterface){
        this.dataLogicInterface = dataLogicInterface;
    }

    public Processo handle(ObjectId processID,Processo updatedProcesso){
        dataLogicInterface.update(processID,updatedProcesso);
        return updatedProcesso;
    }
    public Processo delete(ObjectId processID){
        return dataLogicInterface.delete(processID);
    }
}
