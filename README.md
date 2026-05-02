# Sistema de Cadastro de Usuários

Este projeto é um sistema simples de cadastro de usuários implementado em Java, seguindo uma arquitetura MVC básica com padrões de projeto antigos e estruturas arcaicas, como solicitado.

## Estrutura do Projeto

- **Main.java**: Ponto de entrada da aplicação. Inicializa os componentes usando Factory e executa o loop do menu.
- **controller/UserController.java**: Controla a lógica de interação entre View e Service.
- **view/ConsoleView.java**: Responsável pela interface com o usuário via console.
- **service/UserService.java**: Contém a lógica de negócio e validações.
- **dao/UserDAO.java**: Acesso a dados (in-memory).
- **models/UserModel.java**: Modelo de dados do usuário.
- **validator/UserValidator.java**: Validações estáticas.
- **factory/DAOFactory.java**: Factory simples para criar instâncias de DAO.
- **exceptions/**: Exceções customizadas.

## Padrões de Projeto Utilizados

- **MVC (Model-View-Controller)**: Separação de responsabilidades.
- **DAO (Data Access Object)**: Abstração do acesso a dados.
- **Factory**: Para criação de objetos DAO.
- **Service Layer**: Lógica de negócio isolada.

## Funcionalidades

- Cadastrar usuário
- Atualizar usuário
- Deletar usuário
- Buscar por ID
- Listar todos os usuários