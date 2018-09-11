CREATE DATABASE IF NOT EXISTS teepo;
USE teepo;

CREATE TABLE categorias (
	idCategoria INT(5) PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(32));

CREATE TABLE notas (
	idNota INT(5) PRIMARY KEY AUTO_INCREMENT,
    conteudo TEXT,
    idCategoria INT(5),  
    FOREIGN KEY(idCategoria) REFERENCES categorias(idCategoria));
    
SET GLOBAL time_zone = '-03:00';