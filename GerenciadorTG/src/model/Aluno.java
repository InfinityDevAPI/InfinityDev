package model;

public class Aluno {
	private int id;
	private String emailFatec;
	private String emailFornecido;
	private String nome;
	private String orientador_nome;
	private String turma_matricula;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailFatec() {
		return emailFatec;
	}
	public void setEmailFatec(String emailFatec) {
		this.emailFatec = emailFatec;
	}
	public String getEmailFornecido() {
		return emailFornecido;
	}
	public void setEmailFornecido(String emailFornecido) {
		this.emailFornecido = emailFornecido;
	}
	public String getOrientador_nome() {
		return orientador_nome;
	}
	public void setOrientador_nome(String orientador_nome) {
		this.orientador_nome = orientador_nome;
	}
	public String getTurma_matricula() {
		return turma_matricula;
	}
	public void setTurma_matricula(String turma_matricula) {
		this.turma_matricula = turma_matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
