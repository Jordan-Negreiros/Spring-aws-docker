#!/bin/bash

echo "Provisioning infrastructure..."

echo "Finding my public ip adress..."

MY_PUBLIC_IP="$(curl -s ipinfo.io/ip)"

echo "... your public ip is $MY_PUBLIC_IP"

echo "Starting terraform..."
terraform apply -var "my_public_ip=$MY_PUBLIC_IP/32"

# deploy via terminal
# sudo docker service create --name beerstore -e SPRING_DATASOURCE_URL=jdbc:postgresql://jordan-beerstore-rds.cvrvpcnlq4cj.us-east-1.rds.amazonaws.com:5432/beerstore -p 8080:8080 --network service jordanns/beerstore:0.2
# sudo docker service create --name beerstore -e SPRING_DATASOURCE_URL=jdbc:postgresql://URL_DO_RDS_DA_SUA_CONTA:5432/beerstore -p 8080:8080 --network service <NOME_IMAGEM>:<VERSAO>