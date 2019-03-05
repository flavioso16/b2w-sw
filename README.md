# SW API

O objetivo é possibilitar a equipe de front criar essa aplicação, queremos desenvolver uma API que contenha os dados dos planetas, que podem ser obtidas pela API pública do Star Wars (https://swapi.co/)

Está disponibilizar na API REST com os seguintes serviços:
1. **GET /planet** - Listar planetas do banco de dados
2. **POST /planet** - Adicionar um planeta (com nome, clima e terreno)
3. **GET /planet/{id}** - Buscar por ID no banco de dados
4. **GET /planet/byName/{name}** - Buscar por nome no banco de dados
5. **DELETE /planet/{id}** - Remover planeta
6. **GET /swapi** - Listar planetas da API do Star Wars

## Tecnologias

* Java 8
* Spring Boot 2.1.3
* Spring Webflux 2.1.3
* Servidor Netty
* Banco de dados Cassandra
* Docker 18.06
* Docker Compose 1.22

## Inicialização

Iniciar com o eclipse:
* Importar projeto: File > Import > Existing Maven Projects
* Clicar com o botão direito do mouse na classe Application.java > Run as > Java Application

Iniciar com o Maven

```
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Deploy

Gerar o pacote via maven:

```
mvn package
```

Subir o projeto via Docker Compose:

```
docker-compose up -d --build
```

