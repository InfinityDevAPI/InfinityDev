-- | Criação do Banco de Dados |
CREATE SCHEMA gerenciamentotg; 

USE gerenciamentotg;

-- | Criação das Tabelas |
CREATE TABLE Orientador (
    emailFatec VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(255)
);

CREATE TABLE Turma (
    id INT PRIMARY KEY AUTO_INCREMENT,
    semestre_ano VARCHAR(10)
);

CREATE TABLE Aluno (
    emailFatec VARCHAR(255) PRIMARY KEY,
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