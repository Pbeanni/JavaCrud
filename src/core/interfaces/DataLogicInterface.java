package core.interfaces;

import core.entities.Processo;
import org.bson.types.ObjectId;

import java.util.List;

public interface DataLogicInterface {
    void create(Processo novoProcesso);
    Processo update(ObjectId processID,Processo updatedProcesso);
    List<Processo> get();
    Processo get(ObjectId processID);
    Processo delete(ObjectId processID);
}
