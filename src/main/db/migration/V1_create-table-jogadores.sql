-- Active: 1751546840962@@localhost@3307@kalangoweb
CREATE TABLE jogador(
    id BIGINT NOT NULL auto_increment,
    nome VARCHAR(100) NOT NULL,
    nick_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    PRIMARY KEY(id),
)
