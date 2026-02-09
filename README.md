# 📚 API Gestão de Biblioteca

Esta é uma API REST estratégica desenvolvida para o controle completo de acervos literários e gestão de usuários. O foco principal deste projeto é a aplicação de **Domain-Driven Design (DDD)** simplificado e a garantia de **consistência de dados** em operações de empréstimo.

## 🛠 Tecnologias Utilizadas

* **Linguagem:** Java 21 (LTS)
* **Framework:** Spring Boot 3
* **Persistência:** Spring Data JPA
* **Produtividade:** Lombok
* **Banco de Dados:** PostgreSQL / H2 (In-memory para testes)

## 🚀 Endpoints da API

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **POST** | `/livros` | Cadastra um novo título com validação de ISBN único. |
| **GET** | `/livros` | Lista o acervo com filtros de disponibilidade. |
| **PUT** | `/livros/{id}` | Atualiza informações do livro, mantendo o histórico de registro. |
| **DELETE** | `/livros/{id}` | Remove um título (apenas se não houver pendências). |
| **POST** | `/emprestimos` | Registra a saída de um livro vinculando-o a um usuário. |

## 🛡 Regras de Negócio Implementadas

* **Validação de Disponibilidade:** O sistema impede o empréstimo de um livro que já consta como "Indisponível" no banco de dados.
* **Integridade de ISBN:** Bloqueio de duplicidade de registros para garantir que cada edição seja única no catálogo.
* **Lógica de Devolução:** Cálculo automático de status de entrega e atualização em tempo real do inventário.
* **Data Consistency:** Uso de anotações `@Transactional` para garantir que a reserva do livro e a criação do contrato de empréstimo ocorram de forma atômica.

## 🚀 Futuras Implementações (Roadmap)

- [ ] **Spring Security:** Controle de acesso para Bibliotecários vs. Leitores.
- [ ] **Sistema de Multas:** Lógica para cálculo de atrasos baseado em dias úteis.
- [ ] **Docker:** Containerização da aplicação e do banco de dados para deploy facilitado.

---
Desenvolvido por [Moroni Oliveira](https://github.com/moronioliveira) 