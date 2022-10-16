package core.entities;

import core.entities.valueObjects.EstadoDoProcesso;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Processo {
    private String juiz;
    private String autor;
    private Reu reu;
    private Defesa defesa;
    private List<EstadoDoProcesso> andamento = new ArrayList<>();
    private ObjectId id = new ObjectId();

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }



    public String getJuiz() {
        return juiz;
    }

    public void setJuiz(String juiz) {
        this.juiz = juiz;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Reu getReu() {
        return reu;
    }

    public void setReu(Reu reu) {
        this.reu = reu;
    }

    public Defesa getDefesa() {
        return defesa;
    }

    public void setDefesa(Defesa defesa) {
        this.defesa = defesa;
    }

    public List<EstadoDoProcesso> getAndamento() {
        return andamento;
    }

    public void setAndamento(List<EstadoDoProcesso> andamento) {
        this.andamento = andamento;
    }





    public Processo() {};
    public Processo(String juiz, String autor, Reu reu, Defesa defesa) {
        this.juiz = juiz;
        this.autor = autor;
        this.reu = reu;
        this.defesa = defesa;
    }
    public Processo(String juiz, String autor, Reu reu, Defesa defesa, EstadoDoProcesso andamento) {
        this.juiz = juiz;
        this.autor = autor;
        this.reu = reu;
        this.defesa = defesa;
        this.andamento.add(andamento);
    }

    @Override
    public String toString() {
        return "\n\nID do processo: "+this.id +"\n"+
                "Juiz:"+this.juiz+"\n"+
                "Autor:"+this.autor+"\n"+
                "Informações do reu\n"+
                "Nome: "+this.reu.getName()+","+
                "cpf: "+this.reu.getCpf()+"\n"+
                "Advogado principal: "+this.defesa.getAdvogadoPrincipal()+
                "\nAndamento do processo: "+this.getAndamento()+"\n\n"
                ;
    }
}
