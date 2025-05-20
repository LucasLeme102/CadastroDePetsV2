# 🐾 Cadastro de Pets V2

Um sistema simples em Java para gerenciar o cadastro básico de informações de pets, utilizando JDBC puro para interação com um banco de dados PostgreSQL. Este projeto foca na implementação do CRUD (Create, Read, Update, Delete) de forma "na mão", sem o uso de frameworks ORM.

## 🚀 Funcionalidades

* **Criação (Create):** Adiciona novas informações de pets ao banco de dados.
* **Leitura (Read):** Exibe as informações dos pets cadastrados.
* **Atualização (Update):** Modifica dados de pets existentes.
* **Exclusão (Delete):** Remove registros de pets do banco de dados.

## 💻 Tecnologias Utilizadas

* **Java:** Linguagem de programação principal.
* **JDBC (Java Database Connectivity):** API para conexão e manipulação do banco de dados.
* **PostgreSQL:** Sistema de gerenciamento de banco de dados relacional.
* **Maven:** Ferramenta para gerenciamento de dependências e construção do projeto.
* **Docker & Docker Compose:** Para orquestração e fácil configuração do ambiente do banco de dados.

## ⚙️ Pré-requisitos

Antes de começar, certifique-se de ter os seguintes softwares instalados em sua máquina:

* **Java Development Kit (JDK) 8 ou superior**
* **Apache Maven 3.x**
* **Docker Desktop** (inclui Docker Engine e Docker Compose)

## 📦 Instalação e Execução

Siga os passos abaixo para configurar e rodar o projeto localmente:

### 1. Clonar o Repositório

```bash
git clone do repositório

2. Configurar o Banco de Dados com Docker Compose

O projeto utiliza Docker Compose para levantar uma instância do PostgreSQL com as configurações necessárias.

Variáveis de Ambiente do Banco de Dados:
POSTGRES_USER: admin
POSTGRES_PASSWORD: admin123
POSTGRES_DB: cadastro_pets
No diretório raiz do projeto, execute o seguinte comando para iniciar o contêiner do PostgreSQL:

Bash
docker-compose up -d
Este comando criará e iniciará um contêiner PostgreSQL acessível na porta 5432.

3. Configurar a Conexão JDBC no Projeto Java

Certifique-se de que as configurações de conexão JDBC no seu código Java (provavelmente em uma classe de utilitário ou configuração de conexão) correspondem às variáveis de ambiente definidas no docker-compose.yml.

Exemplo (adapte conforme a sua implementação):

Java
// Exemplo de URL de conexão JDBC
String url = "jdbc:postgresql://localhost:5432/cadastro_pets";
String user = "admin";
String password = "admin123";
// ... use essas credenciais para estabelecer a conexão
4. Compilar e Executar a Aplicação Java


🤝 Contribuições
Contribuições são bem-vindas! Siga estes passos para contribuir:

Faça um fork do projeto.
Crie uma branch para sua feature (git checkout -b feature/MinhaNovaFeature).
Faça o commit das suas alterações (git commit -m 'Adiciona MinhaNovaFeature').
Envie para a branch original (git push origin feature/MinhaNovaFeature).
Abra um Pull Request.
