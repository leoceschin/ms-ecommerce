# Ecommerce baseado em Microsserviços
O principal foco aqui é estudar como funcionam os microsserviços, utilizando Docker para containerização, RabbitMQ para mensageria, bancos de dados descentralizados e o Spring Boot como framework principal.

## Instruções
Após clonar o projeto você deve compilar todos os serviços para poder gerar o .jar nas pastas e o Docker montar as imagens. Para isso, rode o script abaixo:
Linux / MacOS:
```
sh compileFiles.sh
```
Ele percorrerá as subpastas do "server" e irá compilar os projetos que contenham um arquivo "pom.xml".

Com tudo compilado, podemos rodar o docker compose, esse processo pode levar vários minutos.
```
docker-compose up -d
```
Após subir todos os serviços você já pode acessar os recursos da aplicação.