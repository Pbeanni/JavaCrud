package application.CLI;

import core.entities.Defesa;
import core.entities.Processo;
import core.entities.Reu;
import core.interactors.AtualizarProcesso;
import core.interactors.BuscarProcesso;
import core.interactors.CriarProcesso;
import org.bson.types.ObjectId;

import java.util.Scanner;

public class CLI {
    private BuscarProcesso buscarProcesso;
    private AtualizarProcesso atualizarProcesso;
    private CriarProcesso criarProcesso;

    public CLI(BuscarProcesso buscarProcesso, AtualizarProcesso atualizarProcesso, CriarProcesso criarProcesso) {
        this.buscarProcesso = buscarProcesso;
        this.atualizarProcesso = atualizarProcesso;
        this.criarProcesso = criarProcesso;
    }

    public void runCli(){
        Scanner sc = new Scanner(System.in);
        String userDecision = "";
        while(userDecision !="exit") {
            System.out.println("\nComandos:\n'getall' busca todos os processos\n'getid' busca processo por id\n'new' cria um novo processo\n'delete' deleta um processo");
            userDecision = sc.nextLine();
            switch (userDecision) {
                case "getall": {
                    System.out.println(buscarProcesso.all());
                    System.out.print(buscarProcesso.all().size());

                    break;
                }
                case "getid": {
                    System.out.println("\nDigite o ID do processo\n");
                    String id = sc.nextLine();
                    System.out.println(buscarProcesso.byID(new ObjectId(id)));
                    break;
                }
                case "new": {
                    System.out.println("Digite os dados do processo");
                    System.out.println("Nome do juiz\n");
                    String juiz = sc.nextLine();
                    System.out.println("Nome do autor\n");
                    String autor = sc.nextLine();
                    System.out.println("Nome do reu");
                    String reu = sc.nextLine();
                    System.out.println("Cpf do reu");
                    String cpf = sc.nextLine();
                    System.out.println("Advogado Principal");
                    String advogado1 = sc.nextLine();
                    System.out.println("Advogado secundario");
                    String advogado2 = sc.nextLine();
                    Processo novoProcesso = new Processo(juiz, autor, new Reu(reu, cpf), new Defesa(advogado1, advogado2));

                    System.out.println(criarProcesso.create(novoProcesso));
                    break;
                }
                case "delete": {
                    System.out.println("\nDigite o ID do processo\n");
                    String id = sc.nextLine();
                    System.out.println("\nProcesso deletado\n" + atualizarProcesso.delete(new ObjectId(id)));
                    break;
                }
                case "exit":{
                    userDecision = "exit";
                }
            }

        }
        sc.close();
    }
}
