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





Cadastro de Funcionários — API RESTful

API RESTful para cadastro e gerenciamento de funcionários, desenvolvida com Spring Boot. O projeto também disponibiliza uma interface web em Thymeleaf para realizar as operações pelo navegador.

Funcionalidades

•
Cadastro de funcionários.

•
Listagem de todos os funcionários.

•
Consulta de funcionário por ID.

•
Atualização parcial de dados com PATCH.

•
Exclusão de funcionário pela API.

•
Interface web para listar, visualizar, cadastrar, editar e demitir funcionários.

•
Persistência em PostgreSQL.

•
Versionamento do banco de dados com Flyway.

•
Conversão de datas e valores monetários para uso na interface web.


Atenção: o projeto não implementa autenticação ou autorização. Não o utilize diretamente em produção sem adicionar controles de acesso, validações de negócio, tratamento centralizado de erros e configurações seguras para as credenciais do banco.

Tecnologias

•
Java 17

•
Spring Boot 4.0.1

•
Spring Web MVC

•
Spring Data JPA / Hibernate

•
Spring Validation

•
Spring Thymeleaf

•
PostgreSQL

•
Flyway

•
Lombok

•
Maven

Pré-requisitos

Antes de executar a aplicação, instale:

•
JDK 17 ou superior;

•
Docker e Docker Compose, para iniciar o PostgreSQL;

•
Git, caso queira clonar o projeto.

A aplicação está configurada para acessar o PostgreSQL em localhost:5431. O container expõe a porta 5432 internamente e a porta 5431 na máquina host.

Como executar

1. Clone o repositório

Bash


git clone https://github.com/viniciusmullerp/Cadastro-de-Funcionarios-API-RESTFul.git
cd Cadastro-de-Funcionarios-API-RESTFul



2. Inicie o PostgreSQL

Bash


docker compose up -d



O banco será criado com os seguintes dados, conforme docker-compose.yaml:

•
Banco: CadastroDeFuncionarios

•
Usuário: postgres

•
Senha: postgres

•
Porta local: 5431

Na primeira inicialização, o Flyway executará automaticamente a migration localizada em src/main/resources/db/migration.

3. Inicie a aplicação

O repositório contém o Maven Wrapper. Se o arquivo não tiver permissão de execução, use bash diretamente:

Bash


bash ./mvnw spring-boot:run



Alternativamente, torne o wrapper executável e execute-o normalmente:

Bash


chmod +x ./mvnw
./mvnw spring-boot:run



A aplicação ficará disponível em:

Plain Text


http://localhost:8080



4. Acesse a interface web

Abra no navegador:

Plain Text


http://localhost:8080/funcionarios/ui/listar



A interface permite consultar os funcionários cadastrados, abrir detalhes, adicionar novos registros, alterar dados e demitir funcionários.

API REST

A API utiliza o prefixo /funcionarios.

Método
Endpoint
Descrição
POST
/funcionarios/criar
Cadastra um funcionário
GET
/funcionarios/listar
Lista todos os funcionários
GET
/funcionarios/listar/{id}
Consulta um funcionário pelo ID
PATCH
/funcionarios/atualizar/{id}
Atualiza parcialmente um funcionário
DELETE
/funcionarios/demitir/{id}
Remove um funcionário




Modelo de dados

Os campos utilizados no cadastro são:

•
id: identificador gerado pelo banco;

•
nome: nome completo;

•
dataNascimento: data de nascimento;

•
cpf: CPF do funcionário;

•
telefone: telefone;

•
email: endereço de e-mail;

•
imgUrl: URL da imagem do funcionário;

•
salario: salário;

•
cargo: cargo do funcionário.

A API espera datas no formato ISO yyyy-MM-dd, por exemplo 1990-05-20. O campo cargo deve receber um dos nomes do enum Cargos, como DESENVOLVEDOR_BACK_END.

Criar funcionário

Bash


curl -X POST http://localhost:8080/funcionarios/criar \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Maria da Silva",
    "dataNascimento": "1990-05-20",
    "cpf": "123.456.789-00",
    "telefone": "(11 ) 99999-9999",
    "email": "maria.silva@example.com",
    "imgUrl": "https://example.com/imagens/maria.jpg",
    "salario": 7500.00,
    "cargo": "DESENVOLVEDOR_BACK_END"
  }'



Em caso de sucesso, a API responde com HTTP 201 Created e uma mensagem semelhante a:

Plain Text


Funcionario cadastrado com sucesso: Maria da Silva



Listar funcionários

Bash


curl http://localhost:8080/funcionarios/listar



Resposta esperada:

JSON


[
  {
    "id": 1,
    "nome": "Maria da Silva",
    "dataNascimento": "1990-05-20",
    "cpf": "123.456.789-00",
    "telefone": "(11 ) 99999-9999",
    "email": "maria.silva@example.com",
    "imgUrl": "https://example.com/imagens/maria.jpg",
    "salario": 7500.00,
    "cargo": "Desenvolvedor Back-End"
  }
]



Consultar por ID

Bash


curl http://localhost:8080/funcionarios/listar/1



Quando o ID não existe, a API retorna HTTP 404 Not Found.

Atualizar parcialmente

Envie somente os campos que deseja alterar:

Bash


curl -X PATCH http://localhost:8080/funcionarios/atualizar/1 \
  -H "Content-Type: application/json" \
  -d '{
    "salario": 8200.00,
    "cargo": "DESENVOLVEDOR_SENIOR"
  }'



Remover funcionário

Bash


curl -X DELETE http://localhost:8080/funcionarios/demitir/1



A operação retorna HTTP 200 OK quando o funcionário é removido. Para um ID inexistente, retorna HTTP 404 Not Found.

Cargos disponíveis

O enum Cargos contém as seguintes opções:

•
DESENVOLVEDOR_FRONT_END

•
DESENVOLVEDOR_BACK_END

•
DESENVOLVEDOR_FULLSTACK

•
DESENVOLVEDOR_JUNIOR

•
DESENVOLVEDOR_PLENO

•
DESENVOLVEDOR_SENIOR

•
ANALISTA_DE_DADOS

•
UX_UI_DESIGNER

•
TECH_LEAD

•
CIENTISTA_DE_DADOS

•
RH

•
MARKETING

•
RECEPCIONISTA

•
CONTABILIDADE

•
CEO

Estrutura principal

Plain Text


src/
├── main/
│   ├── java/dev/funcionarios/CadastroDeFuncionarios/
│   │   ├── Cargos/                  # Enumeração dos cargos
│   │   └── Funcionarios/            # Controller, service, DTO, model e repository
│   └── resources/
│       ├── db/migration/            # Migrations do Flyway
│       ├── templates/               # Páginas Thymeleaf
│       └── application.yaml         # Configurações da aplicação
└── test/                            # Testes automatizados



Banco de dados

A tabela cadastro é criada pela migration V1__Create_tb_cadastro.sql. Os campos cpf, telefone e email possuem restrição de unicidade, e os demais campos do cadastro são obrigatórios no banco.

As credenciais estão definidas diretamente no arquivo application.yaml para fins de desenvolvimento. Em ambientes reais, prefira variáveis de ambiente ou um gerenciador de segredos.

Testes

Para executar os testes:

Bash


bash ./mvnw test



Os testes dependem de um ambiente compatível com a configuração do projeto. Para os testes que carregam o contexto da aplicação, mantenha o PostgreSQL disponível na porta configurada ou adapte a configuração de testes para utilizar um banco isolado.

Parando o ambiente

Para parar o PostgreSQL sem remover os dados persistidos pelo container:

Bash


docker compose stop



Para remover o container:

Bash


docker compose down



Licença

Este projeto está distribuído sob a licença MIT. Consulte o arquivo LICENSE para obter o texto completo.
