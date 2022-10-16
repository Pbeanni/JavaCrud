package core.interactors;

import core.entities.Processo;
import core.interfaces.DataLogicInterface;
import org.bson.types.ObjectId;

import java.util.List;

public class BuscarProcesso {
    private DataLogicInterface dataLogicInterface;

    public BuscarProcesso(DataLogicInterface dataLogicInterface){
        this.dataLogicInterface = dataLogicInterface;
    }
    public List<Processo> all(){
        return dataLogicInterface.get();
    }
    public Processo byID(ObjectId processID){
        return dataLogicInterface.get(processID);
    }
}
