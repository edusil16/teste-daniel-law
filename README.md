<h2 align="center">
   TESTE PARA EMPRESA DANIEL LAW
</h2>


# Clonando este projeto

```
$ git clone https://github.com/edusil16/teste-daniel-law.git
```

# ❗️ Requisitos

Para executar este projeto, você precisará ter os pacotes instalados:

- [Eclipse IDE]
- [TomCat Configurado]

## 🚀 Tecnologias Utilizadas

  - [Java 8]
  - [JDBC]
  - [Hibernate]

## ⚡️ Iniciar aplicativo

- Faça o clone do projeto.

- Crie um banco de dados e altere as strings de conexão na classe ConnectionFactory.

- [SCRIPT PARA CRIAÇÃO DO BD]

CREATE DATABASE IF NOT EXISTS teste_daniel
CHARACTER SET utf8mb4
COLLATE utf8mb4_0900_ai_ci;

USE teste_daniel;

CREATE TABLE processo_model(
	id_processo int primary key auto_increment not null,
    num_pub varchar(255) not null,
    id_pedido varchar(255) not null,
    dt_publicacao varchar(255) not null,
    requerentes varchar(255) not null,
    titulo varchar(255) not null
)

# ❗️ Falta Desenvolver

- Método para buscar processo e requerente;

# ❗️ Pronto para apresentar

- Chamada via AJAX para obter o HTML;
- Transacional com banco de dados;
