# imagem com alpine linux e jdk 13
FROM openjdk:13-jdk-alpine3.9
LABEL maintainer="jordannegreirossantos@gmail.com"

ENV LANG C.UTF-8

# atualiza o alpine dentro do container
RUN apk add --update bash

# adicionar jar do projeto dentro do container
ADD build/libs/*.jar /app/app.jar

# executa o jar dentro do container
CMD java -jar /app/app.jar $APP_OPTIONS

# comando para exercutar o build: docker build -t jordanns/beerstore:0.1 .
# comando para criar container com o banco PostgreSQL: docker run -p 5432:5432 --name beerdb -e POSTGRES_USER=beerstore -e POSTGRES_PASSWORD=beerstore -e POSTGRES_DB=beerstore -d postgres:10.5-alpine

# comando para criar uma rede docker: docker network create beer-net
# comando para adicionar o beerdb a beer-net: docker network connect beer-net beerdb

# comando para criar o container da aplicação passando o container onde está o banco no APP_OPTIONS
# docker run -p 8080:8080 --rm --network beer-net -e APP_OPTIONS='--spring.datasource.url=jdbc:postgresql://beerdb:5432/beerstore' jordanns/beerstore:0.2