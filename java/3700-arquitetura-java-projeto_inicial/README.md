# Codechella API

API RESTful para gerenciamento de eventos e vendas de ingressos do Codechella.

## Sobre o Projeto

Este projeto é uma API construída com Java e Spring Boot, seguindo as melhores práticas de arquitetura de software para garantir um sistema robusto, escalável e de fácil manutenção.

## Primeiros Passos

Siga as instruções abaixo para executar o projeto em seu ambiente local.

### Pré-requisitos

-   Java 17 ou superior
-   Maven 3.8 ou superior

### Executando a Aplicação

1.  **Clone o repositório:**
    ```bash
    git clone <url-do-repositorio>
    cd 3700-arquitetura-java-projeto_inicial
    ```

2.  **Compile e execute o projeto usando o Maven Wrapper:**
    O Maven Wrapper (`mvnw`) garante que você está usando a versão correta do Maven para o projeto, sem precisar instalá-lo globalmente.

    -   No Linux ou macOS:
        ```bash
        ./mvnw spring-boot:run
        ```
    -   No Windows:
        ```bash
        ./mvnw.cmd spring-boot:run
        ```

3.  **Acesse a API:**
    A API estará disponível em `http://localhost:8080`.

## Exemplos de Requisições

Aqui estão alguns exemplos de como interagir com a API usando `curl`.

### 1. Cadastrar um Novo Usuário

Esta requisição cria um novo usuário no sistema.

```bash
curl -X POST http://localhost:8080/usuarios \
-H "Content-Type: application/json" \
-d '{
    "cpf": "123.456.789-00",
    "nome": "João da Silva",
    "nascimento": "1990-01-01",
    "email": "joao.silva@example.com"
}'
```

### 2. Buscar Próximos Eventos

Esta requisição lista os próximos eventos disponíveis.

```bash
curl -X GET http://localhost:8080/eventos
```

---
*Documentação da arquitetura pode ser encontrada em [`/docs/arquitetura.md`](/docs/arquitetura.md).*


## Comandos docker no Amazon Linux 2023

```bash

sudo yum update -y

sudo dnf install docker -y

sudo service docker start

sudo usermod -a -G docker ec2-user

docker ps

sudo dnf install docker-compose-plugin -y
```

* (ref)[https://medium.com/@fredmanre/how-to-configure-docker-docker-compose-in-aws-ec2-amazon-linux-2023-ami-ab4d10b2bcdc]