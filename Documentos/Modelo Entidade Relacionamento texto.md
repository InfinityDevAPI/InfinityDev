## Modelo Entidade Relacionamento



### Entidades:



#### a) Aluno

- emailFatec (PK)
- emailFornecido
- nome

#### b) Orientador

- emailFatec (PK)
- nome

#### c) TG

- id (PK)
- tipo
- empresa_envolvida
- problema
- disciplina

#### d) Entrega

- id (PK)
- descrição
- data_entrega

#### e) Turma

- id (PK)
- semestre_ano



### Relacionamentos:

- Aluno (0,n) <-> (1,1) Orientador

- Aluno (0,n) <-> (0,n) Entrega

- Aluno (0,n) <-> (1,n) Turma

- Turma (0,n) <-> (0,n) Entrega

  * Atributos de ligação:

    - feedback

    - nota