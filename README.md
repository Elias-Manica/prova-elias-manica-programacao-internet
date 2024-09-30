CREATE TABLE PAIS (
    ID SERIAL PRIMARY KEY,
    NOME VARCHAR(100) NOT NULL,
    SIGLA VARCHAR(3) NOT NULL,
    CONTINENTE VARCHAR(3) NOT NULL,
    POPULACAO BIGINT NOT NULL
);

INSERT INTO PAIS (NOME, SIGLA, CONTINENTE, POPULACAO) VALUES 
('Brasil', 'BRA', 'AMS', 200000000),
('Uruguai', 'URU', 'AMS', 3500000),
('Argentina', 'ARG', 'AMS', 46000000),
('Paraguai', 'PAR', 'AMS', 7000000),
('Chile', 'CHI', 'AMS', 19000000);

CREATE TABLE ESTADO (
    ID SERIAL PRIMARY KEY,
    NOME VARCHAR(100) NOT NULL,
    SIGLA VARCHAR(2) NOT NULL,
    REGIAO VARCHAR(100) NOT NULL,
    PAIS INT NOT NULL,
    CONSTRAINT fk_pais FOREIGN KEY (PAIS) REFERENCES PAIS(ID)
);

INSERT INTO ESTADO (NOME, SIGLA, REGIAO, PAIS) VALUES
('São Paulo', 'SP', 'Sudeste', 1),
('Rio de Janeiro', 'RJ', 'Sudeste', 1),
('Montevideo', 'MO', 'Sul', 2),
('Buenos Aires', 'BA', 'Centro', 3),
('Assunção', 'AS', 'Centro', 4),
('Santiago', 'SA', 'Norte', 5);

CREATE TABLE USUARIO (
    ID SERIAL PRIMARY KEY,
    NOME VARCHAR(100) NOT NULL,
    SENHA VARCHAR(100) NOT NULL
);

INSERT INTO USUARIO (NOME, SENHA) VALUES 
('Elias Manica', 'senha123'),
('admin@gmail.com', 'admin');
