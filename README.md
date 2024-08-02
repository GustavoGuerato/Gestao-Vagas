# Gestão de Vagas de Emprego

Este projeto é um sistema de Gestão de Vagas de Emprego desenvolvido com Spring Boot. O sistema permite gerenciar vagas de emprego, candidaturas e oferece funcionalidades de autenticação de usuários.

## Funcionalidades

1. **Cadastro de Vagas de Emprego**
   - Permite aos administradores criar, editar e remover vagas de emprego.
   - As vagas podem conter informações como título, descrição, requisitos, localização, e data de encerramento.

2. **Candidatura às Vagas**
   - Usuários autenticados podem visualizar e se candidatar a vagas de emprego.
   - As candidaturas são registradas no sistema e podem incluir documentos como currículos.

3. **Gerenciamento de Candidaturas**
   - Administradores podem visualizar as candidaturas recebidas para cada vaga.
   - É possível atualizar o status da candidatura (em análise, aprovado, rejeitado).

4. **Autenticação e Autorização**
   - Implementação de autenticação JWT (JSON Web Token) para proteger endpoints e gerenciar sessões de usuários.
   - Diferenciação de permissões para administradores e candidatos.

5. **Perfil do Usuário**
   - Usuários podem atualizar suas informações pessoais e visualizar o histórico de candidaturas.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para o desenvolvimento da aplicação.
- **JPA (Java Persistence API)**: Utilizado para mapeamento objeto-relacional e gerenciamento de persistência de dados.
- **JWT (JSON Web Token)**: Utilizado para autenticação segura de usuários e proteção de endpoints.
- **Spring Security**: Para implementação de segurança e controle de acesso.
- **H2 Database**: Banco de dados em memória utilizado para desenvolvimento e testes.

## Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/gestao-vagas-emprego.git
   cd gestao-vagas-emprego
