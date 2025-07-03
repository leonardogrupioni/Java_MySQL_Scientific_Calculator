CREATE DATABASE CALCULADORA;

USE CALCULADORA;

CREATE TABLE operacoes(
    tentativa INT AUTO_INCREMENT PRIMARY KEY,
    calculadora VARCHAR(255),
    operando1 DOUBLE,
    operador VARCHAR(255),
    operando2 DOUBLE,
    resultado DOUBLE,
    status VARCHAR(255),
    mensagem VARCHAR(255)
);
