# BoraLer - API REST de livro

Projeto de conclusão do curso Jovem Programador, desenvolvido para gerenciar livros e acompanhar sua situação de leitura.

## Funcionalidades previstas

- RF01 - Cadastrar livro.
- RF02 - Listar Livros.
- RF03 - Buscar livro pelo ID.
- RF04 - Atualizar livro.
- RF05 - Marcar livro como lido.
- RF06 - Excluir livro.

##Tecnologias previstas

- Java 21
- Spring Boot
- Maven
- Spring Data JPA
- Bean Validation
- PostgreSQL no Neon
- Postman
- Git e GitHub

## Banco de dados

O PostgreSQL no Neon substituirá o H2 indicado no material do curso, com autorização do professor.

## Estado do projeto

Estrutura inicial criada, compilação validada e conexão com PostgreSQL no Neon confirmada.
As funcionalidades de livros ainda serão implementadas.

## Configuração e execução

Pré-requisito: JDK 21.

A aplicação utiliza estas variáveis de ambiente:

| Variável | Conteúdo |
|---|---|
| DB_URL | URL JDBC do PostgreSQL no Neon, com SSL |
| DB_USERNAME | Usuário do banco |
| DB_PASSWORD | Senha do banco |

Configure essas variáveis no mesmo terminal usado para iniciar a aplicação. Não inclua credenciais no código ou no GitHub.

Com as variáveis configuradas, abra o terminal na pasta `backend` e execute:

```powershell
.\mvnw.cmd spring-boot:run
```

O servidor inicia na porta 8080.

A aplicação roda localmente e utiliza o banco hospedado no Neon.
Os endpoints serão adicionados nas próximas etapas.

## Evolução futura

Após a entrega da API, o projeto será ampliado com interface React, autenticação, categorias, biblioteca de PDFs e dashboard.

## Autor

Alexandre Milton Alves
Aluno do Jovem Programador - SENAC
