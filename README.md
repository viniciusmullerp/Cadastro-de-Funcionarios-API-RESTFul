# Cadastro de Funcionários — API RESTful

API RESTful para gerenciamento de funcionários, desenvolvida com **Java 17 e Spring Boot**, utilizando arquitetura em camadas, persistência de dados com PostgreSQL e versionamento de banco de dados com Flyway.

O projeto tem como objetivo aplicar conceitos de desenvolvimento back-end, organização de código, validação de dados e conteinerização de serviços.

## Tecnologias utilizadas

- **Java 17** — linguagem de programação.
- **Spring Boot 4** — desenvolvimento da aplicação back-end.
- **Spring Web MVC** — criação de endpoints HTTP.
- **Spring Data JPA** — persistência e acesso aos dados.
- **PostgreSQL** — banco de dados relacional.
- **Flyway** — versionamento e gerenciamento de migrações do banco de dados.
- **Lombok** — redução de código repetitivo.
- **Bean Validation** — validação de dados.
- **Thymeleaf** — suporte à renderização de páginas HTML.
- **Maven** — gerenciamento de dependências e build.
- **Docker Compose** — configuração e execução do banco de dados em contêiner.

## Funcionalidades e recursos

- Estruturação da aplicação utilizando arquitetura em camadas.
- Persistência de dados com Spring Data JPA.
- Integração com PostgreSQL.
- Gerenciamento de alterações no banco de dados com Flyway.
- Validação de dados de entrada.
- Redução de código repetitivo com Lombok.
- Configuração do ambiente de banco de dados com Docker Compose.

## Arquitetura do projeto

A aplicação utiliza uma arquitetura em camadas para organizar as responsabilidades e facilitar a manutenção e a evolução do código.

Essa abordagem permite separar as regras de negócio, o acesso aos dados e a comunicação HTTP, favorecendo a organização e a reutilização dos componentes.

## Pré-requisitos

Antes de executar o projeto, instale:

- [Java JDK 17](https://adoptium.net/)
- [Git](https://git-scm.com/)
- [Docker Desktop](https://www.docker.com/products/docker-desktop/)

O Maven Wrapper (`mvnw` e `mvnw.cmd`) está incluído no repositório.

## Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/viniciusmullerp/Cadastro-de-Funcionarios-API-RESTFul.git
```

### 2. Entre na pasta do projeto

```bash
cd Cadastro-de-Funcionarios-API-RESTFul
```

### 3. Inicie o banco de dados

Com o Docker Desktop em execução, execute:

```bash
docker compose up -d
```

O arquivo `docker-compose.yaml` configura um contêiner PostgreSQL com as seguintes definições de desenvolvimento:

| Configuração | Valor |
|---|---|
| Banco de dados | `CadastroDeFuncionarios` |
| Usuário | `postgres` |
| Porta externa | `5431` |
| Imagem Docker | `postgres:latest` |

**Atenção:** as credenciais acima são as configurações presentes no arquivo Docker Compose do projeto. Utilize credenciais seguras em ambientes de produção.

### 4. Execute a aplicação

No Windows:

```bash
mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

Certifique-se de que as configurações de conexão do PostgreSQL em `src/main/resources/application.properties` ou `application.yml` correspondem ao ambiente iniciado pelo Docker.

### 5. Gere o build da aplicação

Windows:

```bash
mvnw.cmd clean package
```

Linux ou macOS:

```bash
./mvnw clean package
```

## Banco de dados

O PostgreSQL é utilizado para armazenar os dados da aplicação, enquanto o Flyway gerencia as migrações do esquema do banco de dados.

Essa combinação permite manter o histórico de alterações estruturais e tornar a evolução do banco mais organizada.

## Objetivos de aprendizagem

Este projeto permite praticar conceitos importantes para o desenvolvimento back-end, como:

- Desenvolvimento de aplicações Java com Spring Boot.
- Construção de aplicações baseadas em HTTP.
- Persistência de dados utilizando ORM e JPA.
- Organização de código por camadas.
- Validação de dados.
- Versionamento de banco de dados.
- Configuração de serviços com Docker Compose.
- Gerenciamento de dependências com Maven.

## Melhorias futuras

- Documentação interativa dos endpoints com OpenAPI/Swagger.
- Ampliação da cobertura de testes automatizados.
- Implementação de paginação e filtros nas consultas, caso aplicável.
- Configuração de variáveis de ambiente para credenciais.
- Criação de pipeline de integração contínua.

## Autor

**Vinícius Müller**

- GitHub: [@viniciusmullerp](https://github.com/viniciusmullerp)
- LinkedIn: [Vinícius Müller](https://www.linkedin.com/in/vin%C3%ADciusm%C3%BCller/)

## Licença

Este projeto está disponível sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.
