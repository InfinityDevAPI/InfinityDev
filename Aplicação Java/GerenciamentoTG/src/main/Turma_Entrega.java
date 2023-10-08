package main;

public class Turma_Entrega {

    private String feedback;
    private String nota;

    public Turma_Entrega(String feedback, String nota) {
        this.feedback = feedback;
        this.nota = nota;
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
