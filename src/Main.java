import application.CLI.CLI;
import application.MongoAdapter.MongoAdapter;
import core.interactors.AtualizarProcesso;
import core.interactors.BuscarProcesso;
import core.interactors.CriarProcesso;
import org.bson.types.ObjectId;

public class Main {
    public static void main(String[] args) {
        MongoAdapter mongoAdapter = new MongoAdapter();

        BuscarProcesso buscarProcesso = new BuscarProcesso(mongoAdapter);
        CriarProcesso criarProcesso = new CriarProcesso(mongoAdapter);
        AtualizarProcesso atualizarProcesso = new AtualizarProcesso(mongoAdapter);

        CLI cli = new CLI(buscarProcesso,atualizarProcesso,criarProcesso);
        cli.runCli();



    }
}