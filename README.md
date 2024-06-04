# Biblioteca com MongoDB

## Descrição do Projeto

Este projeto é um sistema de biblioteca desenvolvido em Java utilizando a interface gráfica Swing (JFrame) e o banco de dados NoSQL MongoDB. O sistema permite a gestão completa de uma biblioteca, incluindo funcionalidades para CRUD (Create, Read, Update, Delete) de usuários, livros e reservas/devoluções.

## Funcionalidades

- **Usuários**: Cadastro, edição, listagem e exclusão de usuários.
- **Livros**: Cadastro, edição, listagem e exclusão de livros.
- **Reservas/Devoluções**: Criação, edição, listagem e exclusão de reservas e devoluções de livros.
- **Limite de Reservas**: Um usuário pode reservar até 5 livros simultaneamente.
- **Multas**: Aplicação de multas para devoluções de livros após o prazo determinado.
- **Pesquisa**: Pesquisa de obras/livros por autor e título.
- **Histórico**: Listagem do histórico de reservas/devoluções por usuário logado.

## Estrutura do Projeto

O projeto segue o padrão de design MVC (Model-View-Controller) e inclui o uso dos padrões DAO (Data Access Object) e Converter para gerenciamento dos dados e conversões necessárias.

### Padrões de Projeto Utilizados

- **MVC (Model-View-Controller)**: Organiza o código em três componentes principais:
  - **Model**: Representa os dados e a lógica de negócios.
  - **View**: Responsável pela interface com o usuário.
  - **Controller**: Intermediário entre Model e View, gerencia as interações e atualiza a View com base nos dados do Model.

- **DAO (Data Access Object)**: Abstrai e encapsula o acesso ao banco de dados. Fornece uma interface para realizar operações no banco de dados sem expor detalhes de implementação.

- **Converter**: Converte dados entre diferentes tipos de objetos, facilitando a manipulação e a troca de informações entre camadas do sistema.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal para desenvolvimento do sistema.
- **Swing (JFrame)**: Biblioteca gráfica para criação da interface do usuário.
- **MongoDB**: Banco de dados NoSQL utilizado para armazenamento dos dados.
- **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências.

## Requisitos

- **Java JDK 8+**
- **MongoDB 4.0+**
- **Maven**
