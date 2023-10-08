package main;

public class Aluno {

    private String emailFornecido;
    private String nome;

    public Aluno(String emailFornecido, String nome) {
    this.emailFornecido = emailFornecido;
    this.nome = nome;
    }

    public String getEmailFornecido() {
        return emailFornecido;
    }

    public void setEmailFornecido(String emailFornecido) {
        this.emailFornecido = emailFornecido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}