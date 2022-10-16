package core.entities;

public class Defesa {
    private String advogadoPrincipal;
    private String advogadoSecundario;

    public String getAdvogadoPrincipal() {
        return advogadoPrincipal;
    }

    public void setAdvogadoPrincipal(String advogadoPrincipal) {
        this.advogadoPrincipal = advogadoPrincipal;
    }

    public String getAdvogadoSecundario() {
        return advogadoSecundario;
    }

    public void setAdvogadoSecundario(String advogadoSecundario) {
        this.advogadoSecundario = advogadoSecundario;
    }

    public Defesa(String advogadoPrincipal, String advogadoSecundario) {
        this.advogadoPrincipal = advogadoPrincipal;
        this.advogadoSecundario = advogadoSecundario;
    };
    public Defesa() {};
}
