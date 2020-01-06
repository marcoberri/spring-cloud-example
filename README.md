# spring-cloud-example
Esempio di gestione dei microservice

#Docker-compose
docker volume create --name postgres-data-volume -d local
docker-compose -f spring-cloud-stack.yml up --force-recreate --build -d
docker-compose  -f spring-cloud-stack.yml up -d 
docker-compose -f portainer-agent-stack.yml up --force-recreate --build -d


