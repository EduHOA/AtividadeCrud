# RPG API - Documentação

Esta aplicação fornece uma API REST para um sistema de RPG. O objetivo é gerenciar personagens, itens mágicos e suas associações, permitindo a criação, atualização e listagem de dados, bem como a aplicação de regras de negócios específicas.

## Funcionalidades

- **Personagens**
  - Criação de personagens com distribuição de pontos entre força e defesa.
  - Atribuição de itens mágicos aos personagens.
  - Validação de regras durante a criação e atualização de personagens.

- **Itens Mágicos**
  - Criação, atualização e remoção de itens mágicos.
  - Itens podem ser Armas, Armaduras ou Amuletos, com atributos de força e defesa.
  - Amuletos podem ter ambos os atributos, mas o personagem pode ter apenas um amuleto.

## Endpoints

A API inclui os seguintes endpoints:

- **Personagens**
  - `POST /personagens`: Cria um novo personagem.
  - `GET /personagens`: Lista todos os personagens.
  - `GET /personagens/{id}`: Obtém detalhes de um personagem específico.
  - `PUT /personagens/{id}`: Atualiza um personagem existente.
  
- **Itens Mágicos**
  - `POST /item`: Cria um novo item mágico.
  - `GET /item`: Lista todos os itens mágicos.
  - `GET /item/{id}`: Obtém detalhes de um item mágico específico.
  - `DELETE /item/{id}`: Deleta um item mágico.

## Regras de Negócio

- **Itens**
  - Armas não podem ter força e defesa simultaneamente.
  - Armaduras não podem ter força e defesa simultaneamente.
  - Amuletos podem ter tanto força quanto defesa, mas o personagem pode ter apenas um amuleto.
  - A força e defesa de um personagem são determinadas pelos itens mágicos equipados.
  - O personagem tem um total de 10 pontos para distribuir entre força e defesa ao ser criado.

## Swagger

Você pode visualizar a documentação interativa da API através do Swagger.

**Link para o Swagger**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Como Rodar a Aplicação

### Pré-requisitos

- Java 11 ou superior.
- Maven ou Gradle.
- Banco de dados MySQL ou H2.

### Passos para rodar

1. Clone este repositório:

   ```bash
   git clone https://github.com/EduHOA/AtividadeCrud.git
