-- V1 cria tabela de cadastro de funcionarios
CREATE TABLE cadastro (
                         id BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         data_nascimento DATE NOT NULL,
                         cpf VARCHAR(255) NOT NULL UNIQUE,
                         telefone VARCHAR(255) NOT NULL UNIQUE,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         img_url VARCHAR(255) NOT NULL,
                         salario DECIMAL NOT NULL,
                         cargo VARCHAR(255) NOT NULL
)