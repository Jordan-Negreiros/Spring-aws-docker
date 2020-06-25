# imagem com alpine linux e jdk 13
FROM openjdk:13-jdk-alpine3.9
LABEL maintainer="jordannegreirossantos@gmail.com"

ENV LANG C.UTF-8

# atualiza o alpine dentro do container
RUN apk add --update bash

# adicionar jar do projeto dentro do container
ADD build/libs/*.jar /app/app.jar

# executa o jar dentro do container
CMD java -jar /app/app.jar

# comando para exercutar o build docker build -t jordanns/beerstore:0.1 .