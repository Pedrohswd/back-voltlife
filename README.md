
---

## ✅ README - VoltLife Backend (`README.md`)

# ⚙️ VoltLife Backend

Este é o backend do sistema **VoltLife**, uma API RESTful desenvolvida em Java com Spring Boot, responsável por cadastrar dados de residencias e eletronicos.

## 🧰 Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Hibernate
- Lombok
- Swagger (OpenAPI)
- JUnit 5
- Maven

## 📚 Estrutura do Projeto

- `controller/` - Camada de exposição da API (REST)
- `service/` - Regras de negócio
- `repository/` - Acesso a dados
- `domain/` - Entidades do sistema
- `dto/` - Objetos de transferência de dados
- `config/` - Configurações gerais

## 🚀 Funcionalidades

- Cadastro e consulta de usuários, casas e eletronicos
- Geração de relatórios
- Controle de acesso por perfis
- Documentação Swagger integrada

## 📦 Instalação

```bash
git clone https://github.com/seu-usuario/voltlife-backend.git
cd voltlife-backend
./mvnw clean install
