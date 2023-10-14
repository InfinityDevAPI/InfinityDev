CREATE SCHEMA gerenciador;
USE gerenciador;

CREATE TABLE Orientador (
	id INT PRIMARY KEY AUTO_INCREMENT,
    emailFatec VARCHAR(255) ,
    nome VARCHAR(255)
);

CREATE TABLE Turma (
	id INT PRIMARY KEY AUTO_INCREMENT,
    semestre_ano VARCHAR(20)
);
	


CREATE TABLE Aluno (
    emailFatec VARCHAR(255),
    emailFornecido VARCHAR(255),
    nome VARCHAR(255),
    orientador_emailFatec VARCHAR(255),
    turma_id INT,
    FOREIGN KEY (orientador_emailFatec) REFERENCES Orientador(emailFatec),
    FOREIGN KEY (turma_id) REFERENCES Turma(id)
);

CREATE TABLE TG (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(255),
    empresa_envolvida VARCHAR(255),
    problema TEXT,
    disciplina VARCHAR(255)
);

CREATE TABLE Entrega (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descricao TEXT,
    data_entrega DATE,
    turma_id INT,
    feedback TEXT,
    nota FLOAT,
    FOREIGN KEY (turma_id) REFERENCES Turma(id)
);

ALTER TABLE Turma MODIFY COLUMN semestre_ano VARCHAR(20);
ALTER TABLE Orientador ADD INDEX (emailFatec);
ALTER TABLE Aluno MODIFY turma_id INT AUTO_INCREMENT;

