package main;
public class Tg {

    private String tipo;
    private String empresa_envolvida;
    private String problema;

    public Tg(String tipo, String empresa_envolvida, String problema) {
        this.tipo = tipo;
        this.empresa_envolvida = empresa_envolvida;
        this.problema = problema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmpresa_envolvida() {
        return empresa_envolvida;
    }

    public void setEmpresa_envolvida(String empresa_envolvida) {
        this.empresa_envolvida = empresa_envolvida;
    }

    
    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

}
