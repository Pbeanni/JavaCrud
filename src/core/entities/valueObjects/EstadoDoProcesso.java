package core.entities.valueObjects;

public class EstadoDoProcesso {

    private String decisão;
    private String instancia;

    public String getDecisão() {
        return decisão;
    }

    public void setDecisão(String decisão) {
        this.decisão = decisão;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public EstadoDoProcesso(String instancia, String decisão) {
        this.instancia = instancia;
        this.decisão = decisão;
    }
    public EstadoDoProcesso() {}

}
