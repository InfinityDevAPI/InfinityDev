package main;

public class Entrega {

    private String descricao;
    private String data_Entrega;
    private String feedback;
    private String nota;


    public Entrega(String descricao, String data_Entrega, String feedback, String nota) {
        this.descricao = descricao;
        this.data_Entrega = data_Entrega;
        this.feedback = feedback;
        this.nota = nota;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_Entrega() {
        return data_Entrega;
    }

    public void setData_Entrega(String data_Entrega) {
        this.data_Entrega = data_Entrega;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }



}
