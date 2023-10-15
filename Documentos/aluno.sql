CREATE SCHEMA aluno;

CREATE user 'gerenciamento_user'@'localhost' identified by 'admin123';
GRANT SELECT, INSERT, DELETE, UPDATE on aluno.* to gerenciamento_user@'localhost';
	CREATE TABLE alunos(
	emailPessal VARCHAR(100),
    emailFatec VARCHAR(100),
    nome VARCHAR(200),
    nomeOrientador VARCHAR(200),
    emailOrientador VARCHAR(100),
    Matriculado VARCHAR(20),
    TipoTG VARCHAR(200),
    problema VARCHAR(200),
    empresa VARCHAR(200),
    disciplina VARCHAR(200)
    );

